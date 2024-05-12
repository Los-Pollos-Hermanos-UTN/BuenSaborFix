package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.CategoriaFacadeImpl;
import com.example.buensaboruno.business.services.impl.CategoriaServiceImpl;
import com.example.buensaboruno.domain.dtos.CategoriaDTO;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/categoria")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaDTO, Long, CategoriaFacadeImpl> {
    public  CategoriaController(CategoriaFacadeImpl facade){
        super(facade);
    }
}
