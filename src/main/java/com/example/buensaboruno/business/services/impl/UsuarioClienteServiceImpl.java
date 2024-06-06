package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.mapper.ClienteMapper;
import com.example.buensaboruno.business.services.UsuarioClienteService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.repositories.ClienteRepository;
import com.example.buensaboruno.repositories.base.BaseRepository;
import com.example.buensaboruno.repositories.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioClienteServiceImpl extends BaseServiceImpl<UsuarioCliente, Long> implements UsuarioClienteService {
    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public UsuarioClienteServiceImpl(BaseRepository<UsuarioCliente, Long> baseRepository, UsuarioClienteRepository usuarioClienteRepository, ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        super(baseRepository);
        this.usuarioClienteRepository = usuarioClienteRepository;
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDTO getClienteByUsuario(Long id) {
        Optional<UsuarioCliente> usuarioClienteOpt = usuarioClienteRepository.findById(id);
        if (usuarioClienteOpt.isPresent()) {
            UsuarioCliente usuarioCliente = usuarioClienteOpt.get();
            Cliente cliente = clienteRepository.findByUsuario(usuarioCliente);
            if (cliente != null) {
                return clienteMapper.toDTO(cliente);
            }
        }
        return null; // O lanzar una excepción según tu manejo de errores
    }

}
