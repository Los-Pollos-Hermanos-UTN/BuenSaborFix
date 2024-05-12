package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.PaisDTO;
import com.example.buensaboruno.domain.entities.Pais;

import java.util.List;

public interface PaisMapper  extends BaseMapper<Pais, PaisDTO>{
    PaisDTO toDTO(Pais source);
    Pais toEntity(PaisDTO source);
    List<PaisDTO> toDTOsList(List<Pais> source);
    List<Pais> toEntitiesList(List<PaisDTO> source);
}
