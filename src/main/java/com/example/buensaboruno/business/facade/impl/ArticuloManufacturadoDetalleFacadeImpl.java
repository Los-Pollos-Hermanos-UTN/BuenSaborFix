package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoDetalleFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDetalleDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;

public class ArticuloManufacturadoDetalleFacadeImpl extends BaseFacadeImpl<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDTO, Long> implements ArticuloManufacturadoDetalleFacade {
    public ArticuloManufacturadoDetalleFacadeImpl(BaseService<ArticuloManufacturadoDetalle, Long> baseService, BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
