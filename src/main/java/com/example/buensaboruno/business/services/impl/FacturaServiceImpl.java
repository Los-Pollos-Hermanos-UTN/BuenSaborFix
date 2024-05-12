package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.FacturaService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository=facturaRepository;
    }
}
