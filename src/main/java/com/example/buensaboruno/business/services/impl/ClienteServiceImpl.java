package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ClienteService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository){
        super(baseRepository);
        this.clienteRepository = clienteRepository;

    }

}
