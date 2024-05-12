package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.DomicilioFacadeImpl;
import com.example.buensaboruno.domain.dtos.DomicilioDTO;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/domicilio")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioDTO,Long, DomicilioFacadeImpl> {
    public DomicilioController(DomicilioFacadeImpl facade) {
        super(facade);
    }
}
