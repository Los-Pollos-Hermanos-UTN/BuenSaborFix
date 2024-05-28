package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.ImagenBaseMapper;
import com.example.buensaboruno.domain.dtos.ImagenEmpresaDTO;
import com.example.buensaboruno.domain.entities.ImagenEmpresa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenEmpresaMapper extends ImagenBaseMapper<ImagenEmpresa, ImagenEmpresaDTO> {
    ImagenEmpresaDTO toDTO(ImagenEmpresa source);
    ImagenEmpresa toEntity(ImagenEmpresaDTO source);
    List<ImagenEmpresaDTO> toDTOsList(List<ImagenEmpresa> source);
    List<ImagenEmpresa> toEntitiesList(List<ImagenEmpresaDTO> source);
}
