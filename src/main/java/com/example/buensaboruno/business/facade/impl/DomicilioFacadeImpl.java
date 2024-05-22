package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.DomicilioFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.DomicilioDTO;
import com.example.buensaboruno.domain.entities.Domicilio;
import org.springframework.stereotype.Service;

@Service
public class DomicilioFacadeImpl extends BaseFacadeImpl<Domicilio, DomicilioDTO, Long> implements DomicilioFacade {
    public DomicilioFacadeImpl(BaseService<Domicilio, Long> baseService, BaseMapper<Domicilio, DomicilioDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
