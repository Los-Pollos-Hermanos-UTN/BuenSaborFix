package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.LocalidadFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.LocalidadDTO;
import com.example.buensaboruno.domain.entities.Localidad;
import org.springframework.stereotype.Service;

@Service
public class LocalidadFacadeImpl extends BaseFacadeImpl<Localidad, LocalidadDTO, Long> implements LocalidadFacade {
    public LocalidadFacadeImpl(BaseService<Localidad, Long> baseService, BaseMapper<Localidad, LocalidadDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
