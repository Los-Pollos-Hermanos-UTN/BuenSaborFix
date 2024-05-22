package com.example.buensaboruno.business.services.base;

import com.example.buensaboruno.domain.entities.base.ImagenBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

// Interfaz que define los métodos para operaciones con imágenes
public interface ImagenBaseService<E extends ImagenBase, ID extends UUID> {

     ResponseEntity<List<Map<String, Object>>> getAllImages();

     ResponseEntity<String> uploadImages(MultipartFile[] files);

     ResponseEntity<String> deleteImage(String publicId, ID uuid);
}
