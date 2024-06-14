package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.PedidoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.mapper.PedidoMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.PdfService;
import com.example.buensaboruno.business.services.impl.PedidoServiceImpl;
import com.example.buensaboruno.domain.dtos.*;
import com.example.buensaboruno.domain.entities.*;
import com.example.buensaboruno.domain.enums.Estado;
import com.example.buensaboruno.domain.enums.TipoEnvio;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.ArticuloRepository;
import com.example.buensaboruno.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
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
    private PdfService pdfService;

    private JavaMailSender mailSender;


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
        int totalMinutes = 0;
        double totalCost = 0D;

        if (pedidoDTO.getTipoEnvio().equals(TipoEnvio.DELIVERY)) {
            totalMinutes += 10;
        }

        boolean stockSuficiente = true;

        // Verificar stock y calcular tiempo estimado y costo total
        for (DetallePedidoDTO detallePedidoDTO : pedidoDTO.getDetallePedidos()) {
            ArticuloDTO articulo = detallePedidoDTO.getArticulo();
            Optional<ArticuloManufacturado> articuloManufacturado = articuloManufacturadoRepository.findById(articulo.getId());
            Optional<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.findById(articulo.getId());

            if (articuloManufacturado.isPresent()) {
                totalMinutes += articuloManufacturado.get().getTiempoEstimadoMinutos();
                for (ArticuloManufacturadoDetalle articuloManufacturadoDetalle : articuloManufacturado.get().getArticuloManufacturadoDetalles()) {
                    totalCost += articuloManufacturadoDetalle.getArticuloInsumo().getPrecioCompra() * articuloManufacturadoDetalle.getCantidad() * detallePedidoDTO.getCantidad();
                    double stock = articuloManufacturadoDetalle.getArticuloInsumo().getStockActual() - articuloManufacturadoDetalle.getCantidad() * detallePedidoDTO.getCantidad();
                    if (stock <= 0) {
                        stockSuficiente = false;
                    }
                }
            }

            if (articuloInsumo.isPresent() && !articuloInsumo.get().getEsParaElaborar()) {
                totalCost += articuloInsumo.get().getPrecioCompra() * detallePedidoDTO.getCantidad();
                double stock = articuloInsumo.get().getStockActual() - detallePedidoDTO.getCantidad();
                if (stock <= 0) {
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

            // Crear la factura
            Factura factura = Factura.builder()
                    .fechaFcturacion(LocalDate.now())
                    .formaPago(pedidoDTO.getFormaPago())
                    .totalVenta(pedidoDTO.getTotal())
                    .build();

            // Asociar la factura con el pedido
            pedido.setFactura(factura);
            // Generar el PDF
            byte[] pdfBytes = pdfService.generateInvoicePdf(pedido);

            // Enviar el correo electrónico con el PDF adjunto
            sendInvoiceEmail(pedido.getCliente().getEmail(), pdfBytes);
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

    private void sendInvoiceEmail(String to, byte[] pdfBytes) {
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
            message.setTo(to);
            message.setSubject("Factura de su Pedido");
            message.setText("Adjunto encontrará la factura de su pedido.");
            message.addAttachment("Factura.pdf", new ByteArrayResource(pdfBytes));
        };
        mailSender.send(preparator);
    }

    public List<PedidoDTO> listPedidosByCliente(Long id) {
        return pedidoMapper.toDTOsList(pedidoRepository.findByClienteIdAndEliminadoFalse(id));
    }

}
