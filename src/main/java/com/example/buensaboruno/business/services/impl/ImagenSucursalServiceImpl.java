package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenSucursalService;
import com.example.buensaboruno.business.services.base.ImagenBaseServiceImpl;
import com.example.buensaboruno.domain.entities.ImagenSucursal;
import com.example.buensaboruno.repositories.ImagenSucursalRepository;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class ImagenSucursalServiceImpl extends ImagenBaseServiceImpl<ImagenSucursal, UUID> implements ImagenSucursalService {

    private final ImagenSucursalRepository imagenSucursalRepository;

    @Autowired
    private CloudinaryServiceImpl cloudinaryServiceImpl;

    @Autowired
    public ImagenSucursalServiceImpl(ImagenBaseRepository<ImagenSucursal, UUID> imagenBaseRepository, ImagenSucursalRepository imagenSucursalRepository){
        super(imagenBaseRepository);
        this.imagenSucursalRepository = imagenSucursalRepository;
    }

    @Override
    protected ImagenSucursal createImageEntity(){
        return new ImagenSucursal();
    }

    public String saveImage(MultipartFile file) {
        String url = cloudinaryServiceImpl.uploadFile(file);
        return url != null ? url : null;
    }

}
