package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.UsuarioEmpleadoDTO;
import com.example.buensaboruno.domain.entities.UsuarioEmpleado;

import java.util.List;

public interface UsuarioEmpleadoMapper  extends BaseMapper<UsuarioEmpleado, UsuarioEmpleadoDTO>{
    UsuarioEmpleadoDTO toDTO(UsuarioEmpleado source);
    UsuarioEmpleado toEntity(UsuarioEmpleadoDTO source);
    List<UsuarioEmpleadoDTO> toDTOsList(List<UsuarioEmpleado> source);
    List<UsuarioEmpleado> toEntitiesList(List<UsuarioEmpleadoDTO> source);
}
