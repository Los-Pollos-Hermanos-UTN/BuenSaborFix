package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.SucursalService;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalServiceImpl extends BaseServiceImpl<Sucursal, Long> implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalServiceImpl(BaseRepository<Sucursal, Long> baseRepository, SucursalRepository sucursalRepository) {
        super(baseRepository);
        this.sucursalRepository=sucursalRepository;
    }
}
