package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.domain.dtos.UsuarioEmpleadoDTO;
import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioEmpleadoMapper  extends BaseMapper<UsuarioEmpleado, UsuarioEmpleadoDTO> {
    UsuarioEmpleadoDTO toDTO(UsuarioEmpleado source);
    UsuarioEmpleado toEntity(UsuarioEmpleadoDTO source);
    List<UsuarioEmpleadoDTO> toDTOsList(List<UsuarioEmpleado> source);
    List<UsuarioEmpleado> toEntitiesList(List<UsuarioEmpleadoDTO> source);
}
