package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ProvinciaFacadeImpl;
import com.example.buensaboruno.domain.dtos.ProvinciaDTO;
import com.example.buensaboruno.domain.entities.Provincia;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/provincia")
public class ProvinciaController extends BaseControllerImpl<Provincia, ProvinciaDTO, Long, ProvinciaFacadeImpl> {
    public ProvinciaController(ProvinciaFacadeImpl facade){
        super(facade);
    }
}
