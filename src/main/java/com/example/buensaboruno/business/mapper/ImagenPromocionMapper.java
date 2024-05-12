package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ImagenPromocionDTO;
import com.example.buensaboruno.domain.entities.ImagenPromocion;

import java.util.List;

public interface ImagenPromocionMapper  extends BaseMapper<ImagenPromocion, ImagenPromocionDTO>{
    ImagenPromocionDTO toDTO(ImagenPromocion source);
    ImagenPromocion toEntity(ImagenPromocionDTO source);
    List<ImagenPromocionDTO> toDTOsList(List<ImagenPromocion> source);
    List<ImagenPromocion> toEntitiesList(List<ImagenPromocionDTO> source);
}
