package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.UnidadMedidaService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService {
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository, UnidadMedidaRepository unidadMedidaRepository) {
        super(baseRepository);
        this.unidadMedidaRepository=unidadMedidaRepository;
    }
}
