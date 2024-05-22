package com.example.buensaboruno.business.services.base;

import com.example.buensaboruno.business.services.CloudinaryService;
import com.example.buensaboruno.domain.entities.base.ImagenBase;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public abstract class ImagenBaseServiceImpl<E extends ImagenBase, ID extends UUID> implements ImagenBaseService<E, ID> {

    @Autowired
    private CloudinaryService cloudinaryService;

    private ImagenBaseRepository<E, ID> imagenBaseRepository;

    public ImagenBaseServiceImpl(ImagenBaseRepository<E, ID> imagenBaseRepository) {
        this.imagenBaseRepository = imagenBaseRepository;
    }

    protected abstract E createImageEntity();

    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImages() {
        try {
            List<E> images = imagenBaseRepository.findAll();
            List<Map<String, Object>> imageList = new ArrayList<>();

            for (E image : images) {
                Map<String, Object> imageMap = new HashMap<>();
                imageMap.put("id", image.getId());
                imageMap.put("name", image.getName());
                imageMap.put("url", image.getUrl());
                imageList.add(imageMap);
            }

            return ResponseEntity.ok(imageList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files) {
        List<String> urls = new ArrayList<>();

        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    return ResponseEntity.badRequest().build();
                }

                E image = createImageEntity(); // Usar el método abstracto para crear la entidad concreta
                image.setName(file.getOriginalFilename());
                image.setUrl(cloudinaryService.uploadFile(file));

                if (image.getUrl() == null) {
                    return ResponseEntity.badRequest().build();
                }

                imagenBaseRepository.save(image);
                urls.add(image.getUrl());
            }

            return new ResponseEntity<>("{\"status\":\"OK\", \"urls\":" + urls + "}", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, ID idBd) {
        try {
            // Eliminar la imagen en el repositorio
            imagenBaseRepository.deleteById(idBd);

            // Eliminar la imagen en Cloudinary
            Map response = cloudinaryService.deleteImage(publicId, idBd);
            if ("ok".equals(response.get("result"))) {
                return new ResponseEntity<>("{\"status\":\"OK\", \"message\":\"Image deleted successfully.\"}", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"Failed to delete image from Cloudinary.\"}", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

}
