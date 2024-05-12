package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.DetallePedidoFacadeImpl;
import com.example.buensaboruno.domain.dtos.DetallePedidoDTO;
import com.example.buensaboruno.domain.entities.DetallePedido;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/detallePedido")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoDTO, Long, DetallePedidoFacadeImpl> {
    public DetallePedidoController(DetallePedidoFacadeImpl facade){
        super(facade);
    }
}
