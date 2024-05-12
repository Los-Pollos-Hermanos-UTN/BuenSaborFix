package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.UsuarioClienteFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.UsuarioClienteDTO;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteFacadeImpl extends BaseFacadeImpl<UsuarioCliente, UsuarioClienteDTO, Long> implements UsuarioClienteFacade {
    public UsuarioClienteFacadeImpl(BaseService<UsuarioCliente, Long> baseService, BaseMapper<UsuarioCliente, UsuarioClienteDTO> baseMapper){
        super(baseService, baseMapper);
    }
}