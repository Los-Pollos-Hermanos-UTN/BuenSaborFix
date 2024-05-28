package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenArticuloService;
import com.example.buensaboruno.business.services.base.ImagenBaseServiceImpl;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.repositories.ImagenArticuloRepository;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImagenArticuloServiceImpl extends ImagenBaseServiceImpl<ImagenArticulo, UUID> implements ImagenArticuloService {

    private final ImagenArticuloRepository imagenArticuloRepository;

    @Autowired
    private CloudinaryServiceImpl cloudinaryServiceImpl;

    @Autowired
    public ImagenArticuloServiceImpl(ImagenBaseRepository<ImagenArticulo, UUID> imagenBaseRepository, ImagenArticuloRepository imagenArticuloRepository){
        super(imagenBaseRepository);
        this.imagenArticuloRepository = imagenArticuloRepository;
    }

    @Override
    protected ImagenArticulo createImageEntity() {
        return new ImagenArticulo();
    }

    public List<String> saveImages(MultipartFile[] files){
        List<String> imageUrls = new ArrayList<>();
        int i = 0;
        for (MultipartFile file : files) {
            String url = cloudinaryServiceImpl.uploadFile(file);
            i++;
            System.out.println(i);
            if (url != null) {
                imageUrls.add(url);
            } else {
                System.out.println("no xfavor");
                return null;
            }
        }
        return imageUrls;
    }

}
