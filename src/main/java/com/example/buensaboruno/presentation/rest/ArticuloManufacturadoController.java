package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ArticuloManufacturadoFacadeImpl;
import com.example.buensaboruno.domain.dtos.articuloDTO.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articuloManufacturado")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoDTO, Long, ArticuloManufacturadoFacadeImpl> {
    public ArticuloManufacturadoController(ArticuloManufacturadoFacadeImpl facade){
        super(facade);
    }
}
