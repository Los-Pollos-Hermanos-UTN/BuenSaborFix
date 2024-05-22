// ImagenBaseController.java
package com.example.buensaboruno.presentation.base;

import com.example.buensaboruno.domain.dtos.base.ImagenBaseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ImagenBaseController<D extends ImagenBaseDTO, ID extends UUID> {
    ResponseEntity<String> uploadImages(MultipartFile[] files);
    ResponseEntity<String> deleteById(String publicId, String uuidString);
    ResponseEntity<List<Map<String, Object>>> getAll();
}
