package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpleadoFacade;
import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpleadoDTO;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.domain.entities.Empresa;

public class EmpresaFacadeImpl extends BaseFacadeImpl<Empresa, EmpresaDTO, Long> implements EmpresaFacade {
    public EmpresaFacadeImpl(BaseService<Empresa, Long> baseService, BaseMapper<Empresa, EmpresaDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
