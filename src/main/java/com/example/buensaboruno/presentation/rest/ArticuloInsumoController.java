package com.example.buensaboruno.presentation.rest;


import com.example.buensaboruno.business.facade.impl.ArticuloInsumoFacadeImpl;
import com.example.buensaboruno.domain.dtos.articuloDTO.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articuloInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoDTO, Long, ArticuloInsumoFacadeImpl> {
    public ArticuloInsumoController(ArticuloInsumoFacadeImpl facade){
        super(facade);
    }
}
