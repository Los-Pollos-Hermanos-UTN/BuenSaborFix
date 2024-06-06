package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.UsuarioClienteFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.UsuarioClienteService;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.dtos.UsuarioClienteDTO;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteFacadeImpl extends BaseFacadeImpl<UsuarioCliente, UsuarioClienteDTO, Long> implements UsuarioClienteFacade {
    private final UsuarioClienteService usuarioClienteService;

    public UsuarioClienteFacadeImpl(BaseService<UsuarioCliente, Long> baseService, BaseMapper<UsuarioCliente, UsuarioClienteDTO> baseMapper, UsuarioClienteService usuarioClienteService) {
        super(baseService, baseMapper);
        this.usuarioClienteService = usuarioClienteService;
    }

    @Override
    public ClienteDTO getClienteByUsuario(Long id) {
        return usuarioClienteService.getClienteByUsuario(id);
    }
}