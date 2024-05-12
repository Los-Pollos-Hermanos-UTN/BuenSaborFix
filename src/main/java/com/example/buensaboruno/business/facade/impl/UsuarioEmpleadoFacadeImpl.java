package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.UsuarioEmpleadoFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.UsuarioEmpleadoDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.UsuarioEmpleado;

public class UsuarioEmpleadoFacadeImpl extends BaseFacadeImpl<UsuarioEmpleado, UsuarioEmpleadoDTO, Long> implements UsuarioEmpleadoFacade {
    public UsuarioEmpleadoFacadeImpl(BaseService<UsuarioEmpleado, Long> baseService, BaseMapper<UsuarioEmpleado, UsuarioEmpleadoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}