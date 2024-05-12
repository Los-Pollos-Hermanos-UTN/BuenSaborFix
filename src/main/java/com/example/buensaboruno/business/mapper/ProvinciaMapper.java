package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ProvinciaDTO;
import com.example.buensaboruno.domain.entities.Provincia;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProvinciaMapper  extends BaseMapper<Provincia, ProvinciaDTO>{
    ProvinciaDTO toDTO(Provincia source);
    Provincia toEntity(ProvinciaDTO source);
    List<ProvinciaDTO> toDTOsList(List<Provincia> source);
    List<Provincia> toEntitiesList(List<ProvinciaDTO> source);
}
