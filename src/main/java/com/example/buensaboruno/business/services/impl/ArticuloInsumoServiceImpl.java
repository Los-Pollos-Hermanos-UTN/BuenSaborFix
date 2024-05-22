package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ArticuloInsumoService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository){
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }

    public ArticuloInsumo createArticuloInsumo(ArticuloInsumo articuloInsumo) {
        // Aquí podrías agregar validaciones adicionales si es necesario
        return articuloInsumoRepository.save(articuloInsumo);
    }

    public ArticuloInsumo editArticuloInsumo(ArticuloInsumo articuloInsumo, Long id) throws Exception {
        return update(id, articuloInsumo);
    }
}
