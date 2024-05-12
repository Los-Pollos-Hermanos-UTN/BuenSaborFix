package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.FacturaFacadeImpl;
import com.example.buensaboruno.business.facade.impl.ImagenArticuloFacadeImpl;
import com.example.buensaboruno.domain.dtos.FacturaDTO;
import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/imagenArticulo")
public class ImagenArticuloController extends BaseControllerImpl<ImagenArticulo, ImagenArticuloDTO, Long, ImagenArticuloFacadeImpl> {
    public ImagenArticuloController(ImagenArticuloFacadeImpl facade){
        super(facade);
    }
}
