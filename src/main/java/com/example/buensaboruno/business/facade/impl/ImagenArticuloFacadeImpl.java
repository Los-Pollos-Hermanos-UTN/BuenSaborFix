package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenArticuloFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import org.springframework.stereotype.Service;

@Service
public class ImagenArticuloFacadeImpl extends BaseFacadeImpl<ImagenArticulo, ImagenArticuloDTO, Long> implements ImagenArticuloFacade {
    public ImagenArticuloFacadeImpl(BaseService<ImagenArticulo, Long> baseService, BaseMapper<ImagenArticulo, ImagenArticuloDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
