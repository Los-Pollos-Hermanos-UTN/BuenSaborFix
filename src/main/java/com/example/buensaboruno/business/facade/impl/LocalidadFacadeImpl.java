package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.LocalidadFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.LocalidadDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.Localidad;

public class LocalidadFacadeImpl extends BaseFacadeImpl<Localidad, LocalidadDTO, Long> implements LocalidadFacade {
    public LocalidadFacadeImpl(BaseService<Localidad, Long> baseService, BaseMapper<Localidad, LocalidadDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
