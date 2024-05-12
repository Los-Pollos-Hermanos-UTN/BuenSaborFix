package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenArticuloService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.ImagenArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenArticuloServiceImpl extends BaseServiceImpl<ImagenArticulo, Long> implements ImagenArticuloService {
    @Autowired
    private ImagenArticuloRepository imagenArticuloRepository;

    public ImagenArticuloServiceImpl(BaseRepository<ImagenArticulo, Long> baseRepository, ImagenArticuloRepository imagenArticuloRepository) {
        super(baseRepository);
        this.imagenArticuloRepository=imagenArticuloRepository;
    }
}
