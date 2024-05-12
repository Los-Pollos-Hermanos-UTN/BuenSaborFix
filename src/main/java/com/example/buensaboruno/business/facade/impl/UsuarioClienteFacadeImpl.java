package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.UsuarioClienteFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.UsuarioClienteDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.UsuarioCliente;

public class UsuarioClienteFacadeImpl extends BaseFacadeImpl<UsuarioCliente, UsuarioClienteDTO, Long> implements UsuarioClienteFacade {
    public UsuarioClienteFacadeImpl(BaseService<UsuarioCliente, Long> baseService, BaseMapper<UsuarioCliente, UsuarioClienteDTO> baseMapper){
        super(baseService, baseMapper);
    }
}