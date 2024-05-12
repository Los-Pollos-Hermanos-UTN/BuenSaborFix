package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.PromocionFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.Promocion;

public class PromocionFacadeImpl extends BaseFacadeImpl<Promocion, PromocionDTO, Long> implements PromocionFacade {
    public PromocionFacadeImpl(BaseService<Promocion, Long> baseService, BaseMapper<Promocion, PromocionDTO> baseMapper){
        super(baseService, baseMapper);
    }
}