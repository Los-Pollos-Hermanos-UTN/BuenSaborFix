package com.example.buensaboruno.business.facade;

import com.example.buensaboruno.business.facade.base.BaseFacade;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.dtos.UsuarioClienteDTO;

public interface UsuarioClienteFacade extends BaseFacade<UsuarioClienteDTO, Long> {
    ClienteDTO getClienteByUsuario(Long id);
}
