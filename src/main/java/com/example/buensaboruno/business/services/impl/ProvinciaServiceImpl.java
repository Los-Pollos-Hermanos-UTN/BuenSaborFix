package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ProvinciaService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.Provincia;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaServiceImpl extends BaseServiceImpl<Provincia, Long> implements ProvinciaService {
    @Autowired
    private ProvinciaRepository provinciaRepository;

    public ProvinciaServiceImpl(BaseRepository<Provincia, Long> baseRepository, ProvinciaRepository provinciaRepository) {
        super(baseRepository);
        this.provinciaRepository=provinciaRepository;
    }
}
