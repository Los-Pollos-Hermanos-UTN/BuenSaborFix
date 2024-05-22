package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenClienteFacade;
import com.example.buensaboruno.business.facade.base.ImagenBaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ImagenClienteMapper;
import com.example.buensaboruno.business.services.ImagenClienteService;
import com.example.buensaboruno.domain.dtos.ImagenClienteDTO;
import com.example.buensaboruno.domain.entities.ImagenCliente;
import org.springframework.stereotype.Component;

@Component
public class ImagenClienteFacadeImpl extends ImagenBaseFacadeImpl<ImagenCliente, ImagenClienteDTO> implements ImagenClienteFacade {

    public ImagenClienteFacadeImpl(ImagenClienteService service, ImagenClienteMapper mapper) {
        super(service, mapper);
    }
}
