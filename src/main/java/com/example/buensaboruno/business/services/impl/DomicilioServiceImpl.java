package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.DomicilioService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository=domicilioRepository;
    }
}
