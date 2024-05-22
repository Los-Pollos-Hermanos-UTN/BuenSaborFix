package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.ImagenBaseMapper;
import com.example.buensaboruno.domain.dtos.ImagenPromocionDTO;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenPromocionMapper extends ImagenBaseMapper<ImagenPromocion, ImagenPromocionDTO> {
    ImagenPromocionDTO toDTO(ImagenPromocion source);
    ImagenPromocion toEntity(ImagenPromocionDTO source);
    List<ImagenPromocionDTO> toDTOsList(List<ImagenPromocion> source);
    List<ImagenPromocion> toEntitiesList(List<ImagenPromocionDTO> source);
}
