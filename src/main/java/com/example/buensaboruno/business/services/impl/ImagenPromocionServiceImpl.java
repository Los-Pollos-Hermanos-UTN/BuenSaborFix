package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenPromocionService;
import com.example.buensaboruno.business.services.base.ImagenBaseServiceImpl;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import com.example.buensaboruno.repositories.ImagenPromocionRepository;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImagenPromocionServiceImpl extends ImagenBaseServiceImpl<ImagenPromocion, UUID> implements ImagenPromocionService {

    private final ImagenPromocionRepository imagenPromocionRepository;

    @Autowired
    public ImagenPromocionServiceImpl(ImagenBaseRepository<ImagenPromocion, UUID> imagenBaseRepository, ImagenPromocionRepository imagenPromocionRepository){
        super(imagenBaseRepository);
        this.imagenPromocionRepository = imagenPromocionRepository;
    }

    @Override
    protected ImagenPromocion createImageEntity() {
        return new ImagenPromocion();
    }
}
