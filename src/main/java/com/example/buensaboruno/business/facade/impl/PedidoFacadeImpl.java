package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.PedidoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.mapper.PedidoMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.PedidoServiceImpl;
import com.example.buensaboruno.domain.dtos.*;
import com.example.buensaboruno.domain.entities.*;
import com.example.buensaboruno.domain.enums.Estado;
import com.example.buensaboruno.domain.enums.TipoEnvio;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoFacadeImpl extends BaseFacadeImpl<Pedido, PedidoDTO, Long> implements PedidoFacade {

    public PedidoFacadeImpl(BaseService<Pedido, Long> baseService, BaseMapper<Pedido, PedidoDTO> baseMapper){
        super(baseService, baseMapper);
    }

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    private PedidoServiceImpl pedidoServiceImpl;

    @Autowired
    private PedidoMapper pedidoMapper;

    public List<PedidoDTO> findPedidosByEmpresaId(Long empresaId) {
        return pedidoMapper.toDTOsList(pedidoRepository.findByEmpresaId(empresaId));
    }

    public PedidoDTO findById(Long id) throws Exception {
        try {
            Pedido pedido = baseService.findById(id);
            return pedidoMapper.toDTO(pedido);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public PedidoDTO editPedidoDTO(Long id, PedidoDTO pedidoDTO) throws Exception {
        Pedido existingPedido = pedidoRepository.findById(id).orElseThrow(() -> new Exception("Pedido no encontrado"));

        if (pedidoDTO.getEstado() == Estado.CANCELADO || pedidoDTO.getEstado() == Estado.RECHAZADO) {
            if (existingPedido.getEstado() == Estado.PENDIENTE) {
                sumarStock(existingPedido);
            } else if (existingPedido.getEstado() == Estado.PREPARACION) {
                throw new Exception("No se puede cancelar o rechazar un pedido en preparación");
            }
        }

        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        pedido = pedidoServiceImpl.update(id, pedido);
        return pedidoMapper.toDTO(pedido);
    }

    @Transactional
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) throws Exception {
        int totalMinutes = 0;
        double totalCost = 0D;
        boolean stockSuficiente = true;

        if (pedidoDTO.getTipoEnvio().equals(TipoEnvio.DELIVERY)) {
            totalMinutes += 10;
        }

        for (DetallePedidoDTO detallePedidoDTO : pedidoDTO.getDetallePedidos()) {
            ArticuloDTO articulo = detallePedidoDTO.getArticulo();
            Optional<ArticuloManufacturado> articuloManufacturado = articuloManufacturadoRepository.findById(articulo.getId());
            Optional<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.findById(articulo.getId());

            if (articuloManufacturado.isPresent()) {
                totalMinutes += articuloManufacturado.get().getTiempoEstimadoMinutos();
                for (ArticuloManufacturadoDetalle articuloManufacturadoDetalle : articuloManufacturado.get().getArticuloManufacturadoDetalles()) {
                    totalCost += articuloManufacturadoDetalle.getArticuloInsumo().getPrecioCompra() * articuloManufacturadoDetalle.getCantidad() * detallePedidoDTO.getCantidad();
                    double stock = articuloManufacturadoDetalle.getArticuloInsumo().getStockActual() - articuloManufacturadoDetalle.getCantidad() * detallePedidoDTO.getCantidad();
                    if (stock < 0) {
                        stockSuficiente = false;
                    }
                }
            }

            if (articuloInsumo.isPresent() && !articuloInsumo.get().getEsParaElaborar()) {
                totalCost += articuloInsumo.get().getPrecioCompra() * detallePedidoDTO.getCantidad();
                double stock = articuloInsumo.get().getStockActual() - detallePedidoDTO.getCantidad();
                if (stock < 0) {
                    stockSuficiente = false;
                }
            }
        }

        LocalTime horaEstimadaFinalizacion = LocalTime.now().plusMinutes(totalMinutes);
        pedidoDTO.setHoraEstimadaFinalizacion(horaEstimadaFinalizacion);
        pedidoDTO.setTotalCosto(totalCost);

        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);

        if (stockSuficiente) {
            restarStock(pedidoDTO);
            pedido.setEstado(Estado.PENDIENTE);

            Factura factura = Factura.builder()
                    .fechaFcturacion(LocalDate.now())
                    .formaPago(pedidoDTO.getFormaPago())
                    .totalVenta(pedidoDTO.getTotal())
                    .build();

            pedido.setFactura(factura);
        } else {
            pedido.setEstado(Estado.RECHAZADO);
        }

        pedido = pedidoRepository.save(pedido);
        return pedidoMapper.toDTO(pedido);
    }

    private void restarStock(PedidoDTO pedidoDTO) {
        for (DetallePedidoDTO detallePedidoDTO : pedidoDTO.getDetallePedidos()) {
            ArticuloDTO articulo = detallePedidoDTO.getArticulo();
            Optional<ArticuloManufacturado> articuloManufacturado = articuloManufacturadoRepository.findById(articulo.getId());
            Optional<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.findById(articulo.getId());

            if (articuloManufacturado.isPresent()) {
                for (ArticuloManufacturadoDetalle articuloManufacturadoDetalle : articuloManufacturado.get().getArticuloManufacturadoDetalles()) {
                    ArticuloInsumo articuloInsumo1 = articuloManufacturadoDetalle.getArticuloInsumo();
                    double stock = articuloInsumo1.getStockActual() - articuloManufacturadoDetalle.getCantidad() * detallePedidoDTO.getCantidad();
                    articuloInsumo1.setStockActual(stock);
                    articuloInsumoRepository.save(articuloInsumo1);
                }
            }

            if (articuloInsumo.isPresent() && !articuloInsumo.get().getEsParaElaborar()) {
                double stock = articuloInsumo.get().getStockActual() - detallePedidoDTO.getCantidad();
                articuloInsumo.get().setStockActual(stock);
                articuloInsumoRepository.save(articuloInsumo.get());
            }
        }
    }

    private void sumarStock(Pedido pedido) {
        for (DetallePedido detallePedido : pedido.getDetallePedidos()) {
            Articulo articulo = detallePedido.getArticulo();
            Optional<ArticuloManufacturado> articuloManufacturado = articuloManufacturadoRepository.findById(articulo.getId());
            Optional<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.findById(articulo.getId());

            if (articuloManufacturado.isPresent()) {
                for (ArticuloManufacturadoDetalle articuloManufacturadoDetalle : articuloManufacturado.get().getArticuloManufacturadoDetalles()) {
                    ArticuloInsumo articuloInsumo1 = articuloManufacturadoDetalle.getArticuloInsumo();
                    double stock = articuloInsumo1.getStockActual() + articuloManufacturadoDetalle.getCantidad() * detallePedido.getCantidad();
                    articuloInsumo1.setStockActual(stock);
                    articuloInsumoRepository.save(articuloInsumo1);
                }
            }

            if (articuloInsumo.isPresent() && !articuloInsumo.get().getEsParaElaborar()) {
                double stock = articuloInsumo.get().getStockActual() + detallePedido.getCantidad();
                articuloInsumo.get().setStockActual(stock);
                articuloInsumoRepository.save(articuloInsumo.get());
            }
        }
    }

    public List<PedidoDTO> listPedidosByCliente(Long id) {
        return pedidoMapper.toDTOsList(pedidoRepository.findByClienteIdAndEliminadoFalse(id));
    }
}
