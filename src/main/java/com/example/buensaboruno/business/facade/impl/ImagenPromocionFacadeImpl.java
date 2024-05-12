package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenPromocionFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.ImagenPromocionDTO;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import org.springframework.stereotype.Service;

@Service
public class ImagenPromocionFacadeImpl extends BaseFacadeImpl<ImagenPromocion, ImagenPromocionDTO, Long> implements ImagenPromocionFacade {
    public ImagenPromocionFacadeImpl(BaseService<ImagenPromocion, Long> baseService, BaseMapper<ImagenPromocion, ImagenPromocionDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
