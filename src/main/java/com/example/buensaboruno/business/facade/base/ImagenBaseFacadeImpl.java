// ImagenBaseFacadeImpl.java
package com.example.buensaboruno.business.facade.base;

import com.example.buensaboruno.business.mapper.base.ImagenBaseMapper;
import com.example.buensaboruno.business.services.base.ImagenBaseService;
import com.example.buensaboruno.domain.dtos.base.ImagenBaseDTO;
import com.example.buensaboruno.domain.entities.base.ImagenBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class ImagenBaseFacadeImpl<E extends ImagenBase, D extends ImagenBaseDTO> implements ImagenBaseFacade<D, UUID> {

    protected final ImagenBaseService<E, UUID> service;
    protected final ImagenBaseMapper<E, D> mapper;

    public ImagenBaseFacadeImpl(ImagenBaseService<E, UUID> service, ImagenBaseMapper<E, D> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImages() {
        return service.getAllImages();
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files) {
        return service.uploadImages(files);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, UUID uuid) {
        return service.deleteImage(publicId, uuid);
    }
}
