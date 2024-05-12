package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.SucursalDTO;
import com.example.buensaboruno.domain.entities.Sucursal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SucursalMapper  extends BaseMapper<Sucursal, SucursalDTO>{
    SucursalDTO toDTO(Sucursal source);
    Sucursal toEntity(SucursalDTO source);
    List<SucursalDTO> toDTOsList(List<Sucursal> source);
    List<Sucursal> toEntitiesList(List<SucursalDTO> source);
}
