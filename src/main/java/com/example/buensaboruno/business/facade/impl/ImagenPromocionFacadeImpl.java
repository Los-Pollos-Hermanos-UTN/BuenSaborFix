package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.ImagenPromocionFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.ImagenPromocionDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.ImagenPromocion;

public class ImagenPromocionFacadeImpl extends BaseFacadeImpl<ImagenPromocion, ImagenPromocionDTO, Long> implements ImagenPromocionFacade {
    public ImagenPromocionFacadeImpl(BaseService<ImagenPromocion, Long> baseService, BaseMapper<ImagenPromocion, ImagenPromocionDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
