package com.example.buensaboruno.business.services;

import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.entities.UsuarioCliente;

public interface UsuarioClienteService extends BaseService<UsuarioCliente, Long> {
    ClienteDTO getClienteByUsuario(Long id);
}
