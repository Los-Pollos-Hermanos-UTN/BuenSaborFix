package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ClienteFacadeImpl;
import com.example.buensaboruno.business.services.impl.ClienteServiceImpl;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/cliente")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteDTO, Long, ClienteFacadeImpl> {
    public ClienteController(ClienteFacadeImpl facade){
        super(facade);
    }
}
