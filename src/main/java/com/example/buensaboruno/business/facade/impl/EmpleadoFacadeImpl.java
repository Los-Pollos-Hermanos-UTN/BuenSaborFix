package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.DomicilioFacade;
import com.example.buensaboruno.business.facade.EmpleadoFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.DomicilioDTO;
import com.example.buensaboruno.domain.dtos.EmpleadoDTO;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.domain.entities.Empleado;

public class EmpleadoFacadeImpl extends BaseFacadeImpl<Empleado, EmpleadoDTO, Long> implements EmpleadoFacade {
    public EmpleadoFacadeImpl(BaseService<Empleado, Long> baseService, BaseMapper<Empleado, EmpleadoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
