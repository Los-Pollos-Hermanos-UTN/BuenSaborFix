package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenClienteService;
import com.example.buensaboruno.domain.entities.ImagenCliente;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.ImagenClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenClienteServiceImpl extends BaseServiceImpl<ImagenCliente, Long> implements ImagenClienteService {
    @Autowired
    private ImagenClienteRepository imagenClienteRepository;

    public ImagenClienteServiceImpl(BaseRepository<ImagenCliente, Long> baseRepository, ImagenClienteRepository imagenClienteRepository) {
        super(baseRepository);
        this.imagenClienteRepository=imagenClienteRepository;
    }
}
