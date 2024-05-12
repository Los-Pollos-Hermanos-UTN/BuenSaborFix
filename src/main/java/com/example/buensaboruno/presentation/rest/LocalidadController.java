package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.LocalidadFacadeImpl;
import com.example.buensaboruno.domain.dtos.LocalidadDTO;
import com.example.buensaboruno.domain.entities.Localidad;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/localidad")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadDTO, Long, LocalidadFacadeImpl> {
    public LocalidadController(LocalidadFacadeImpl facade){
        super(facade);
    }
}
