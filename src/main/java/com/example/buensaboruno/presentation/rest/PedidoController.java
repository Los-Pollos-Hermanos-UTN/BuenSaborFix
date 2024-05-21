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
}
