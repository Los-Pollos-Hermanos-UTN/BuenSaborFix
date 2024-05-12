package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.UsuarioEmpleadoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.UsuarioEmpleadoDTO;
import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEmpleadoFacadeImpl extends BaseFacadeImpl<UsuarioEmpleado, UsuarioEmpleadoDTO, Long> implements UsuarioEmpleadoFacade {
    public UsuarioEmpleadoFacadeImpl(BaseService<UsuarioEmpleado, Long> baseService, BaseMapper<UsuarioEmpleado, UsuarioEmpleadoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}