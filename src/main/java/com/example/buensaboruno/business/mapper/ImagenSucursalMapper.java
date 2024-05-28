package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.ImagenBaseMapper;
import com.example.buensaboruno.domain.dtos.ImagenSucursalDTO;
import com.example.buensaboruno.domain.entities.ImagenSucursal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenSucursalMapper extends ImagenBaseMapper<ImagenSucursal, ImagenSucursalDTO> {
    ImagenSucursalDTO toDTO(ImagenSucursal source);
    ImagenSucursal toEntity(ImagenSucursalDTO source);
    List<ImagenSucursalDTO> toDTOsList(List<ImagenSucursal> source);
    List<ImagenSucursal> toEntitiesList(List<ImagenSucursalDTO> source);
}
