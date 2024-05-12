package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.UsuarioClienteService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteServiceImpl extends BaseServiceImpl<UsuarioCliente, Long> implements UsuarioClienteService {
    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    public UsuarioClienteServiceImpl(BaseRepository<UsuarioCliente, Long> baseRepository, UsuarioClienteRepository usuarioClienteRepository) {
        super(baseRepository);
        this.usuarioClienteRepository=usuarioClienteRepository;
    }
}
