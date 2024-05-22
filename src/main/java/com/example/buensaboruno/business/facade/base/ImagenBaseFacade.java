// ImagenBaseFacade.java
package com.example.buensaboruno.business.facade.base;

import com.example.buensaboruno.domain.dtos.base.ImagenBaseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ImagenBaseFacade<D extends ImagenBaseDTO, ID extends UUID> {
    ResponseEntity<List<Map<String, Object>>> getAllImages();
    ResponseEntity<String> uploadImages(MultipartFile[] files);
    ResponseEntity<String> deleteImage(String publicId, ID uuid);
}
