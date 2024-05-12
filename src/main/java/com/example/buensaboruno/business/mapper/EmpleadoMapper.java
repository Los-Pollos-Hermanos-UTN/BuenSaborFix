package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.EmpleadoDTO;
import com.example.buensaboruno.domain.entities.Empleado;

import java.util.List;

public interface EmpleadoMapper extends BaseMapper<Empleado, EmpleadoDTO>{
    EmpleadoDTO toDTO(Empleado source);
    Empleado toEntity(EmpleadoDTO source);
    List<EmpleadoDTO> toDTOsList(List<Empleado> source);
    List<Empleado> toEntitiesList(List<EmpleadoDTO> source);
}
