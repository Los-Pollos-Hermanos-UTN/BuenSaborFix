package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.PromocionDetalleFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.PromocionDetalleDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.PromocionDetalle;

public class PromocionDetalleFacadeImpl extends BaseFacadeImpl<PromocionDetalle, PromocionDetalleDTO, Long> implements PromocionDetalleFacade {
    public PromocionDetalleFacadeImpl(BaseService<PromocionDetalle, Long> baseService, BaseMapper<PromocionDetalle, PromocionDetalleDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
