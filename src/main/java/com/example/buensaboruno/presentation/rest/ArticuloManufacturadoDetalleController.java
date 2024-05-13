package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ArticuloManufacturadoDetalleFacadeImpl;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDetalleDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articuloManufacturadoDetalle")
public class ArticuloManufacturadoDetalleController extends BaseControllerImpl<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDTO, Long, ArticuloManufacturadoDetalleFacadeImpl> {
    public ArticuloManufacturadoDetalleController(ArticuloManufacturadoDetalleFacadeImpl facade){
        super(facade);
    }
}
