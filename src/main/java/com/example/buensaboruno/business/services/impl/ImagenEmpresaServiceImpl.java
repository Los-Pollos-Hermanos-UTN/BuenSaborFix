package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenEmpresaService;
import com.example.buensaboruno.business.services.base.ImagenBaseServiceImpl;
import com.example.buensaboruno.domain.entities.ImagenEmpresa;
import com.example.buensaboruno.repositories.ImagenEmpresaRepository;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class ImagenEmpresaServiceImpl extends ImagenBaseServiceImpl<ImagenEmpresa, UUID> implements ImagenEmpresaService {

    private final ImagenEmpresaRepository imagenEmpresaRepository;

    @Autowired
    private CloudinaryServiceImpl cloudinaryServiceImpl;

    @Autowired
    public ImagenEmpresaServiceImpl(ImagenBaseRepository<ImagenEmpresa, UUID> imagenBaseRepository, ImagenEmpresaRepository imagenEmpresaRepository){
        super(imagenBaseRepository);
        this.imagenEmpresaRepository = imagenEmpresaRepository;
    }

    @Override
    protected ImagenEmpresa createImageEntity(){
        return new ImagenEmpresa();
    }

    public String saveImage(MultipartFile file) {
        String url = cloudinaryServiceImpl.uploadFile(file);
        return url != null ? url : null;
    }

}
