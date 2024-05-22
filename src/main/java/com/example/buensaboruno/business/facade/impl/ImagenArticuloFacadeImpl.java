package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenArticuloFacade;
import com.example.buensaboruno.business.facade.base.ImagenBaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ImagenArticuloMapper;
import com.example.buensaboruno.business.services.ImagenArticuloService;
import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import org.springframework.stereotype.Component;

@Component
public class ImagenArticuloFacadeImpl extends ImagenBaseFacadeImpl<ImagenArticulo, ImagenArticuloDTO> implements ImagenArticuloFacade {

    public ImagenArticuloFacadeImpl(ImagenArticuloService service, ImagenArticuloMapper mapper) {
        super(service, mapper);
    }
}
