package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.EmpleadoFacadeImpl;
import com.example.buensaboruno.domain.dtos.EmpleadoDTO;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/empleado")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoDTO, Long, EmpleadoFacadeImpl> {
    public EmpleadoController(EmpleadoFacadeImpl facade){
        super(facade);
    }
}
