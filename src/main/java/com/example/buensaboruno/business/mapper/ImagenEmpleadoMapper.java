package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ImagenEmpleadoDTO;
import com.example.buensaboruno.domain.entities.ImagenEmpleado;

import java.util.List;

public interface ImagenEmpleadoMapper extends BaseMapper<ImagenEmpleado, ImagenEmpleadoDTO>{
    ImagenEmpleadoDTO toDTO(ImagenEmpleado source);
    ImagenEmpleado toEntity(ImagenEmpleadoDTO source);
    List<ImagenEmpleadoDTO> toDTOsList(List<ImagenEmpleado> source);
    List<ImagenEmpleado> toEntitiesList(List<ImagenEmpleadoDTO> source);
}
