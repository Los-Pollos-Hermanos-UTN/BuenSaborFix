package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.PedidoFacadeImpl;
import com.example.buensaboruno.domain.dtos.CategoriaDTO;
import com.example.buensaboruno.domain.dtos.PedidoDTO;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoDTO, Long, PedidoFacadeImpl> {
    public PedidoController(PedidoFacadeImpl facade){
        super(facade);
    }

    @Autowired
    private PedidoFacadeImpl pedidoFacadeImpl;

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

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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
        if(pedidos.isEmpty()){
            return new ResponseEntity<>(pedidos, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/empresa/{id}/listByDay", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PedidoDTO>> listPedidosByDay(@RequestParam LocalDate fecha, @PathVariable Long id){
        List<PedidoDTO> pedidos = pedidoFacadeImpl.listPedidosByDay(fecha, id);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }


}
