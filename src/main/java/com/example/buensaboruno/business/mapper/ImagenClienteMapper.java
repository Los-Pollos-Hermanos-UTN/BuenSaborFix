package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ImagenClienteDTO;
import com.example.buensaboruno.domain.entities.ImagenCliente;

import java.util.List;

public interface ImagenClienteMapper extends BaseMapper<ImagenCliente, ImagenClienteDTO>{
    ImagenClienteDTO toDTO(ImagenCliente source);
    ImagenCliente toEntity(ImagenClienteDTO source);
    List<ImagenClienteDTO> toDTOsList(List<ImagenCliente> source);
    List<ImagenCliente> toEntitiesList(List<ImagenClienteDTO> source);
}
