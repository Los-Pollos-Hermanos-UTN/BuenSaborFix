package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenEmpleadoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.ImagenEmpleadoDTO;
import com.example.buensaboruno.domain.entities.ImagenEmpleado;
import org.springframework.stereotype.Service;

@Service
public class ImagenEmpleadoFacadeImpl extends BaseFacadeImpl<ImagenEmpleado, ImagenEmpleadoDTO, Long> implements ImagenEmpleadoFacade {
    public ImagenEmpleadoFacadeImpl(BaseService<ImagenEmpleado, Long> baseService, BaseMapper<ImagenEmpleado, ImagenEmpleadoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}