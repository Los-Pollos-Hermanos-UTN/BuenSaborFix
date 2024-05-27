package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.mapper.PromocionDetalleMapper;
import com.example.buensaboruno.business.services.PromocionDetalleService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.PromocionDetalle;
import com.example.buensaboruno.repositories.base.BaseRepository;
import com.example.buensaboruno.repositories.PromocionDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocionDetalleServiceImpl extends BaseServiceImpl<PromocionDetalle, Long> implements PromocionDetalleService {
    @Autowired
    private PromocionDetalleRepository promocionDetalleRepository;
    private PromocionDetalleMapper promocionDetalleMapper;

    public PromocionDetalleServiceImpl(BaseRepository<PromocionDetalle, Long> baseRepository, PromocionDetalleRepository promocionDetalleRepository, PromocionDetalleMapper promocionDetalleMapper) {
        super(baseRepository);
        this.promocionDetalleRepository=promocionDetalleRepository;
        this.promocionDetalleMapper=promocionDetalleMapper;
    }
}
