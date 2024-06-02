package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenClienteService;
import com.example.buensaboruno.business.services.base.ImagenBaseServiceImpl;
import com.example.buensaboruno.domain.entities.ImagenCliente;
import com.example.buensaboruno.repositories.ImagenClienteRepository;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class ImagenClienteServiceImpl extends ImagenBaseServiceImpl<ImagenCliente, UUID> implements ImagenClienteService {

    private final ImagenClienteRepository imagenClienteRepository;

    @Autowired
    private CloudinaryServiceImpl cloudinaryServiceImpl;

    @Autowired
    public ImagenClienteServiceImpl(ImagenBaseRepository<ImagenCliente, UUID> imagenBaseRepository, ImagenClienteRepository imagenClienteRepository) {
        super(imagenBaseRepository);
        this.imagenClienteRepository = imagenClienteRepository;
    }

    @Override
    protected ImagenCliente createImageEntity() {
        return new ImagenCliente();
    }


    public String saveImage(MultipartFile file) {
        String url = cloudinaryServiceImpl.uploadFile(file);
        return url != null ? url : null;
    }
}

