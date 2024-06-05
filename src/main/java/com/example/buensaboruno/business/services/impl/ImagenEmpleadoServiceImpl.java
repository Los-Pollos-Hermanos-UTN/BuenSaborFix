package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenEmpleadoService;
import com.example.buensaboruno.business.services.base.ImagenBaseServiceImpl;
import com.example.buensaboruno.domain.entities.ImagenEmpleado;
import com.example.buensaboruno.repositories.ImagenEmpleadoRepository;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class ImagenEmpleadoServiceImpl extends ImagenBaseServiceImpl<ImagenEmpleado, UUID> implements ImagenEmpleadoService {

    private final ImagenEmpleadoRepository imagenEmpleadoRepository;

    @Autowired
    private CloudinaryServiceImpl cloudinaryServiceImpl;

    @Autowired
    public ImagenEmpleadoServiceImpl(ImagenBaseRepository<ImagenEmpleado, UUID> imagenBaseRepository, ImagenEmpleadoRepository imagenEmpleadoRepository){
        super(imagenBaseRepository);
        this.imagenEmpleadoRepository = imagenEmpleadoRepository;
    }

    @Override
    protected ImagenEmpleado createImageEntity() {
        return new ImagenEmpleado();
    }

    public String saveImage(MultipartFile file) {
        String url = cloudinaryServiceImpl.uploadFile(file);
        return url != null ? url : null;
    }
}

