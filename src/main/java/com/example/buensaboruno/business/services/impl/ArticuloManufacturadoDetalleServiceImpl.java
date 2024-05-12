package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ArticuloManufacturadoDetalleService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;
import com.example.buensaboruno.repositories.ArticuloManufacturadoDetalleRepository;
import com.example.buensaboruno.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoDetalleServiceImpl extends BaseServiceImpl<ArticuloManufacturadoDetalle, Long> implements ArticuloManufacturadoDetalleService {

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    public ArticuloManufacturadoDetalleServiceImpl(BaseRepository<ArticuloManufacturadoDetalle, Long> baseRepository, ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository){
        super(baseRepository);
        this.articuloManufacturadoDetalleRepository = articuloManufacturadoDetalleRepository;

    }

}
