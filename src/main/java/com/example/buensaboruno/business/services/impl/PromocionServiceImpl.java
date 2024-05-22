package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.PromocionService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.Promocion;
import com.example.buensaboruno.repositories.base.BaseRepository;
import com.example.buensaboruno.repositories.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocionServiceImpl extends BaseServiceImpl<Promocion, Long> implements PromocionService {
    @Autowired
    private PromocionRepository promocionRepository;

    public PromocionServiceImpl(BaseRepository<Promocion, Long> baseRepository, PromocionRepository promocionRepository) {
        super(baseRepository);
        this.promocionRepository=promocionRepository;
    }
}
