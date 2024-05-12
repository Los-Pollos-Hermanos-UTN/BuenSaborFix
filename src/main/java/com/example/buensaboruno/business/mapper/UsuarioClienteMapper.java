package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.UsuarioClienteDTO;
import com.example.buensaboruno.domain.entities.UsuarioCliente;

import java.util.List;

public interface UsuarioClienteMapper  extends BaseMapper<UsuarioCliente, UsuarioClienteDTO>{
    UsuarioClienteDTO toDTO(UsuarioCliente source);
    UsuarioCliente toEntity(UsuarioClienteDTO source);
    List<UsuarioClienteDTO> toDTOsList(List<UsuarioCliente> source);
    List<UsuarioCliente> toEntitiesList(List<UsuarioClienteDTO> source);
}
