package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.articuloDTO.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoFacadeImpl extends BaseFacadeImpl<ArticuloManufacturado, ArticuloManufacturadoDTO, Long> implements ArticuloManufacturadoFacade {
    public ArticuloManufacturadoFacadeImpl(BaseService<ArticuloManufacturado, Long> baseService, BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
