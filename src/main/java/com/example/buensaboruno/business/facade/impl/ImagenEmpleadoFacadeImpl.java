package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenEmpleadoFacade;
import com.example.buensaboruno.business.facade.base.ImagenBaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ImagenEmpleadoMapper;
import com.example.buensaboruno.business.services.ImagenEmpleadoService;
import com.example.buensaboruno.domain.dtos.ImagenEmpleadoDTO;
import com.example.buensaboruno.domain.entities.ImagenEmpleado;
import org.springframework.stereotype.Component;

@Component
public class ImagenEmpleadoFacadeImpl extends ImagenBaseFacadeImpl<ImagenEmpleado, ImagenEmpleadoDTO> implements ImagenEmpleadoFacade {

    public ImagenEmpleadoFacadeImpl(ImagenEmpleadoService service, ImagenEmpleadoMapper mapper) {
        super(service, mapper);
    }
}
