package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.PaisService;
import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl extends BaseServiceImpl<Pais, Long> implements PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public PaisServiceImpl(BaseRepository<Pais, Long> baseRepository, PaisRepository paisRepository) {
        super(baseRepository);
        this.paisRepository=paisRepository;
    }
}
