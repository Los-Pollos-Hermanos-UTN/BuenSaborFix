package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.DomicilioDTO;
import com.example.buensaboruno.domain.entities.Domicilio;

import java.util.List;

public interface DomicilioMapper extends BaseMapper<Domicilio, DomicilioDTO>{
    DomicilioDTO toDTO(Domicilio source);
    Domicilio toEntity(DomicilioDTO source);
    List<DomicilioDTO> toDTOsList(List<Domicilio> source);
    List<Domicilio> toEntitiesList(List<DomicilioDTO> source);
}
