package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.UsuarioClienteFacadeImpl;
import com.example.buensaboruno.domain.dtos.UsuarioClienteDTO;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/usuarioCliente")
public class UsuarioClienteController extends BaseControllerImpl<UsuarioCliente, UsuarioClienteDTO, Long, UsuarioClienteFacadeImpl> {
    public UsuarioClienteController(UsuarioClienteFacadeImpl facade){
        super(facade);
    }
}
