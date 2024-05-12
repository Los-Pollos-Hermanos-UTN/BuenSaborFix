package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.domain.entities.ImagenArticulo;

import java.util.List;

public interface ImagenArticuloMapper extends BaseMapper<ImagenArticulo, ImagenArticuloDTO>{
    ImagenArticuloDTO toDTO(ImagenArticulo source);
    ImagenArticulo toEntity(ImagenArticuloDTO source);
    List<ImagenArticuloDTO> toDTOsList(List<ImagenArticulo> source);
    List<ImagenArticulo> toEntitiesList(List<ImagenArticuloDTO> source);
}

