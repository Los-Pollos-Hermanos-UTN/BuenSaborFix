package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;

public class ArticuloManufacturadoFacadeImpl extends BaseFacadeImpl<ArticuloManufacturado, ArticuloManufacturadoDTO, Long> implements ArticuloManufacturadoFacade {
    public ArticuloManufacturadoFacadeImpl(BaseService<ArticuloManufacturado, Long> baseService, BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
