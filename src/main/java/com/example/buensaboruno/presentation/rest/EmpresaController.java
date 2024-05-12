package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.EmpresaFacadeImpl;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/empresa")
public class EmpresaController extends BaseControllerImpl<Empresa, EmpresaDTO, Long, EmpresaFacadeImpl> {
    public EmpresaController(EmpresaFacadeImpl facade){
        super(facade);
    }
}
