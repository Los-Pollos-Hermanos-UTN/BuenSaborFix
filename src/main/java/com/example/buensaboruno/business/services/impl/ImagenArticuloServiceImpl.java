package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenArticuloService;
import com.example.buensaboruno.business.services.base.ImagenBaseServiceImpl;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.repositories.ImagenArticuloRepository;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImagenArticuloServiceImpl extends ImagenBaseServiceImpl<ImagenArticulo, UUID> implements ImagenArticuloService {

    private final ImagenArticuloRepository imagenArticuloRepository;

    @Autowired
    public ImagenArticuloServiceImpl(ImagenBaseRepository<ImagenArticulo, UUID> imagenBaseRepository, ImagenArticuloRepository imagenArticuloRepository){
        super(imagenBaseRepository);
        this.imagenArticuloRepository = imagenArticuloRepository;
    }

    @Override
    protected ImagenArticulo createImageEntity() {
        return new ImagenArticulo();
    }

}
