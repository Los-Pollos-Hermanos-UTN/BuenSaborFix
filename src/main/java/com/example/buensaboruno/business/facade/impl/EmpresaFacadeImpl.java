package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import org.springframework.stereotype.Service;

@Service
public class EmpresaFacadeImpl extends BaseFacadeImpl<Empresa, EmpresaDTO, Long> implements EmpresaFacade {
    public EmpresaFacadeImpl(BaseService<Empresa, Long> baseService, BaseMapper<Empresa, EmpresaDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
