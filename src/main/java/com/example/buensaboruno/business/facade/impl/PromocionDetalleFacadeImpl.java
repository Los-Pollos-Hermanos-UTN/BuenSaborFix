package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.PromocionDetalleFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.PromocionDetalleDTO;
import com.example.buensaboruno.domain.entities.PromocionDetalle;
import org.springframework.stereotype.Service;

@Service
public class PromocionDetalleFacadeImpl extends BaseFacadeImpl<PromocionDetalle, PromocionDetalleDTO, Long> implements PromocionDetalleFacade {
    public PromocionDetalleFacadeImpl(BaseService<PromocionDetalle, Long> baseService, BaseMapper<PromocionDetalle, PromocionDetalleDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
