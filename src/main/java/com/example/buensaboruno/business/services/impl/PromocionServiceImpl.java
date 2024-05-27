package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.mapper.PromocionMapper;
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
    private PromocionMapper promocionMapper;

    public PromocionServiceImpl(BaseRepository<Promocion, Long> baseRepository, PromocionRepository promocionRepository, PromocionMapper promocionMapper) {
        super(baseRepository);
        this.promocionRepository=promocionRepository;
        this.promocionMapper=promocionMapper;
    }
}
