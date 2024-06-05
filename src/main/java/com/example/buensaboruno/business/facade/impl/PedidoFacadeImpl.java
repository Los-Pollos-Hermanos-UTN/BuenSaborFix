package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.PedidoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.mapper.PedidoMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.PedidoServiceImpl;
import com.example.buensaboruno.domain.dtos.*;
import com.example.buensaboruno.domain.entities.*;
import com.example.buensaboruno.domain.enums.TipoEnvio;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.ArticuloRepository;
import com.example.buensaboruno.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<PedidoDTO> pedidoDTOS = pedidoMapper.toDTOsList(pedidoRepository.findByEmpresaId(empresaId));
        return pedidoDTOS;
    }

    @Transactional
    public PedidoDTO editPedidoDTO(Long id, PedidoDTO pedidoDTO) throws Exception {
        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        pedido = pedidoServiceImpl.update(id, pedido);
        return pedidoMapper.toDTO(pedido);
    }

    @Transactional
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) throws Exception {
        // Buscar articulos que sean manufacturados y su tiempo de preparacion para ir sumando
        // + 10 min x envio
        int totalMinutes = 0;
        double totalCost = 0D;
        if(pedidoDTO.getTipoEnvio().equals(TipoEnvio.DELIVERY)){
            totalMinutes += 10;
        }
        for (DetallePedidoDTO detallePedidoDTO : pedidoDTO.getDetallePedidos()){
            ArticuloDTO articulo = detallePedidoDTO.getArticulo();
            Optional<ArticuloManufacturado> articuloManufacturado = articuloManufacturadoRepository.findById(articulo.getId());
            Optional<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.findById(articulo.getId());
            if(articuloManufacturado.isPresent()){
                totalMinutes += articuloManufacturado.get().getTiempoEstimadoMinutos();
                for(ArticuloManufacturadoDetalle articuloManufacturadoDetalle : articuloManufacturado.get().getArticuloManufacturadoDetalles()){
                    totalCost += articuloManufacturadoDetalle.getArticuloInsumo().getPrecioCompra();
                }
            }
            if(articuloInsumo.isPresent()){
                if(!articuloInsumo.get().getEsParaElaborar()){
                    totalCost += articuloInsumo.get().getPrecioCompra();
                }
            }
        }
        LocalTime horaEstimadaFinalizacion = LocalTime.now().plusMinutes(totalMinutes);
        pedidoDTO.setHoraEstimadaFinalizacion(horaEstimadaFinalizacion);
        pedidoDTO.setTotalCosto(totalCost);
        restarStock(pedidoDTO);
        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        return pedidoMapper.toDTO(pedidoRepository.save(pedido));
    }

    public void restarStock(PedidoDTO pedidoDTO) throws Exception {
        for (DetallePedidoDTO detallePedidoDTO : pedidoDTO.getDetallePedidos()){
            double stock = 0D;
            ArticuloDTO articulo = detallePedidoDTO.getArticulo();
            Optional<ArticuloManufacturado> articuloManufacturado = articuloManufacturadoRepository.findById(articulo.getId());
            Optional<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.findById(articulo.getId());
            if(articuloManufacturado.isPresent()){
                for(ArticuloManufacturadoDetalle articuloManufacturadoDetalle : articuloManufacturado.get().getArticuloManufacturadoDetalles()){
                    ArticuloInsumo articuloInsumo1 = articuloManufacturadoDetalle.getArticuloInsumo();
                    stock = articuloInsumo1.getStockActual() - articuloManufacturadoDetalle.getCantidad() * detallePedidoDTO.getCantidad();
                    if(stock < 0){
                        throw new Exception("El pedido no se puede hacer, falta: "+ articuloInsumo1.getDenominacion());
                    }
                    articuloInsumo1.setStockActual(stock);
                    articuloInsumoRepository.save(articuloInsumo1);
                }
            }
            if(articuloInsumo.isPresent()){
                stock = articuloInsumo.get().getStockActual() - detallePedidoDTO.getCantidad();
                if(stock < 0){
                    throw new Exception("El pedido no se puede hacer, falta: "+ articuloInsumo.get().getDenominacion());
                }
                articuloInsumo.get().setStockActual(stock);
                articuloInsumoRepository.save(articuloInsumo.get());
            }
        }
    }

}
