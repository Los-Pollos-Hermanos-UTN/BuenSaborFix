package com.example.buensaboruno.presentation.base;

import com.example.buensaboruno.business.facade.base.ImagenBaseFacade;
import com.example.buensaboruno.domain.dtos.base.ImagenBaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class ImagenBaseControllerImpl<D extends ImagenBaseDTO> implements ImagenBaseController<D, UUID> {

    @Autowired
    protected ImagenBaseFacade<D, UUID> imageFacade;

    @Override
    @PostMapping("/uploads")
    public ResponseEntity<String> uploadImages(@RequestParam(value = "uploads", required = true) MultipartFile[] files) {
        try {
            return imageFacade.uploadImages(files);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred during upload");
        }
    }

    @Override
    @PostMapping("/deleteImg")
    public ResponseEntity<String> deleteById(@RequestParam(value = "publicId", required = true) String publicId, @RequestParam(value = "uuid", required = true) String uuidString) {
        try {
            UUID uuid = UUID.fromString(uuidString);
            return imageFacade.deleteImage(publicId, uuid);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid UUID format");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred during deletion");
        }
    }

    @Override
    @GetMapping("/getImages")
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        try {
            return imageFacade.getAllImages();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
