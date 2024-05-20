package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ArticuloManufacturadoService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository){
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }

    public ArticuloManufacturado createArticuloManufacturado(ArticuloManufacturado articuloManufacturado) {
        // Aquí podrías agregar validaciones adicionales si es necesario
        return articuloManufacturadoRepository.save(articuloManufacturado);
    }

    public ArticuloManufacturado editArticuloManufacturado(ArticuloManufacturado articuloManufacturado, Long id) throws Exception {
        return update(id, articuloManufacturado);
    }

}
