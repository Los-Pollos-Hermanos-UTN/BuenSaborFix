package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.FacturaFacadeImpl;
import com.example.buensaboruno.business.facade.impl.PedidoFacadeImpl;
import com.example.buensaboruno.business.services.PdfService;
import com.example.buensaboruno.domain.dtos.FacturaDTO;
import com.example.buensaboruno.domain.dtos.PedidoDTO;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoDTO, Long, PedidoFacadeImpl> {

    public PedidoController(PedidoFacadeImpl facade){
        super(facade);
    }

    @Autowired
    private PedidoFacadeImpl pedidoFacadeImpl;

    @Autowired
    private PdfService pdfService;

    @GetMapping(value = "/listByEmpresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PedidoDTO>> listPedidosByEmpresa(@PathVariable Long id) {
        List<PedidoDTO> pedidoDTOS = pedidoFacadeImpl.findPedidosByEmpresaId(id);
        return new ResponseEntity<>(pedidoDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPedido(@RequestBody PedidoDTO pedidoDTO){
        try{
            PedidoDTO createdPedido = pedidoFacadeImpl.createPedido(pedidoDTO);
            return new ResponseEntity<>(createdPedido, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO){
        try{
            PedidoDTO editedPedidoDTO = pedidoFacadeImpl.editPedidoDTO(id, pedidoDTO);
            return new ResponseEntity<>(editedPedidoDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoDTO>> getPedidosByClienteId(@PathVariable Long clienteId) {
        List<PedidoDTO> pedidos = pedidoFacadeImpl.listPedidosByCliente(clienteId);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(pedidos);
        }
    }


    @Autowired
    private FacturaFacadeImpl facturaFacadeImpl; // Inyecta el Facade de Factura




    @GetMapping(value = "/{id}/factura", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacturaDTO> getFacturaByPedidoId(@PathVariable Long id) {
        try {
            PedidoDTO pedidoDTO = facade.findById(id);
            if (pedidoDTO != null && pedidoDTO.getFactura() != null) {
                FacturaDTO facturaDTO = facturaFacadeImpl.findById(pedidoDTO.getFactura().getId());
                if (facturaDTO != null) {
                    return new ResponseEntity<>(facturaDTO, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pdf/{pedidoId}")
    public ResponseEntity<?> generatePDFReport(@PathVariable Long pedidoId) {
        try {
            PedidoDTO pedido = pedidoFacadeImpl.findById(pedidoId);
            FacturaDTO factura = pedido.getFactura();

            if (factura == null) {
                return ResponseEntity.status(404).body("Factura no encontrada para el pedido: " + pedidoId);
            }

            ByteArrayInputStream in = pdfService.generateFacturaPDF(factura, pedido);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=factura_" + pedidoId + ".pdf");

            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error generando el reporte PDF: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Pedido no encontrado: " + e.getMessage());
        }
    }
}
