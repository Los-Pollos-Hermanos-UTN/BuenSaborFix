package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ImagenPromocionFacadeImpl;
import com.example.buensaboruno.domain.dtos.ImagenPromocionDTO;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/imagenPromocion")
public class ImagenPromocionController extends BaseControllerImpl<ImagenPromocion, ImagenPromocionDTO, Long, ImagenPromocionFacadeImpl> {
    public ImagenPromocionController(ImagenPromocionFacadeImpl facade){
        super(facade);
    }
}
