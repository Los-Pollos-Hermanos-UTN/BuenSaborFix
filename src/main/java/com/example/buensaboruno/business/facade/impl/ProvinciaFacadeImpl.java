package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ProvinciaFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.ProvinciaDTO;
import com.example.buensaboruno.domain.entities.Provincia;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaFacadeImpl extends BaseFacadeImpl<Provincia, ProvinciaDTO, Long> implements ProvinciaFacade {
    public ProvinciaFacadeImpl(BaseService<Provincia, Long> baseService, BaseMapper<Provincia, ProvinciaDTO> baseMapper){
        super(baseService, baseMapper);
    }
}