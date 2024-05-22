package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenPromocionFacade;
import com.example.buensaboruno.business.facade.base.ImagenBaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ImagenPromocionMapper;
import com.example.buensaboruno.business.services.ImagenPromocionService;
import com.example.buensaboruno.domain.dtos.ImagenPromocionDTO;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import org.springframework.stereotype.Component;

@Component
public class ImagenPromocionFacadeImpl extends ImagenBaseFacadeImpl<ImagenPromocion, ImagenPromocionDTO> implements ImagenPromocionFacade {

    public ImagenPromocionFacadeImpl(ImagenPromocionService service, ImagenPromocionMapper mapper) {
        super(service, mapper);
    }
}
