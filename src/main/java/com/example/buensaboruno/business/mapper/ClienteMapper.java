package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.entities.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDTO> {
    ClienteDTO toDTO(Cliente source);
    Cliente toEntity(ClienteDTO source);
    List<ClienteDTO> toDTOsList(List<Cliente> source);
    List<Cliente> toEntitiesList(List<ClienteDTO> source);
}