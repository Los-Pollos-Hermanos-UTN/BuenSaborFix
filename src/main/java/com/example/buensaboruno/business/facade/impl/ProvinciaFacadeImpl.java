package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.ProvinciaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.ProvinciaDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.Provincia;

public class ProvinciaFacadeImpl extends BaseFacadeImpl<Provincia, ProvinciaDTO, Long> implements ProvinciaFacade {
    public ProvinciaFacadeImpl(BaseService<Provincia, Long> baseService, BaseMapper<Provincia, ProvinciaDTO> baseMapper){
        super(baseService, baseMapper);
    }
}