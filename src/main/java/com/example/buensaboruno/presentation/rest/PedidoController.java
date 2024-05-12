package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.PedidoFacadeImpl;
import com.example.buensaboruno.domain.dtos.PedidoDTO;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoDTO, Long, PedidoFacadeImpl> {
    public PedidoController(PedidoFacadeImpl facade){
        super(facade);
    }
}
