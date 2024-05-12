package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenClienteService;
import com.example.buensaboruno.business.services.ImagenPromocionService;
import com.example.buensaboruno.domain.entities.ImagenCliente;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.ImagenClienteRepository;
import com.example.buensaboruno.repositories.ImagenPromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenPromocionServiceImpl extends BaseServiceImpl<ImagenPromocion, Long> implements ImagenPromocionService {
    @Autowired
    private ImagenPromocionRepository imagenPromocionRepository;

    public ImagenPromocionServiceImpl(BaseRepository<ImagenPromocion, Long> baseRepository, ImagenPromocionRepository imagenPromocionRepository) {
        super(baseRepository);
        this.imagenPromocionRepository=imagenPromocionRepository;
    }
}
