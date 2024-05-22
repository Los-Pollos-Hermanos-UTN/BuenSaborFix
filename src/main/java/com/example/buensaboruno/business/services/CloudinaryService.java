package com.example.buensaboruno.business.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.UUID;

// Interfaz que define los métodos para interactuar con Cloudinary
public interface CloudinaryService {

    // Método para subir un archivo a Cloudinary
    public default String uploadFile(MultipartFile file) {
        return null; // Implementación por defecto que retorna null
    }

    // Método para eliminar una imagen de Cloudinary
    public Map<String, String> deleteImage(String publicId, UUID uuid);
}
