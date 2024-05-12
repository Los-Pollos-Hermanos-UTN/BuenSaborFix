package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.SucursalFacadeImpl;
import com.example.buensaboruno.domain.dtos.SucursalDTO;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/sucursal")
public class SucursalController extends BaseControllerImpl<Sucursal, SucursalDTO, Long, SucursalFacadeImpl> {
    public SucursalController(SucursalFacadeImpl facade){
        super(facade);
    }
}
