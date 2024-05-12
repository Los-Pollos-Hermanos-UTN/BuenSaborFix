package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ProvinciaDTO;
import com.example.buensaboruno.domain.entities.Provincia;

import java.util.List;

public interface ProvinciaMapper  extends BaseMapper<Provincia, ProvinciaDTO>{
    ProvinciaDTO toDTO(Provincia source);
    Provincia toEntity(ProvinciaDTO source);
    List<ProvinciaDTO> toDTOsList(List<Provincia> source);
    List<Provincia> toEntitiesList(List<ProvinciaDTO> source);
}
