package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.ImagenBaseMapper;
import com.example.buensaboruno.domain.dtos.ImagenClienteDTO;
import com.example.buensaboruno.domain.entities.ImagenCliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenClienteMapper extends ImagenBaseMapper<ImagenCliente, ImagenClienteDTO> {
    ImagenClienteDTO toDTO(ImagenCliente source);
    ImagenCliente toEntity(ImagenClienteDTO source);
    List<ImagenClienteDTO> toDTOsList(List<ImagenCliente> source);
    List<ImagenCliente> toEntitiesList(List<ImagenClienteDTO> source);
}
