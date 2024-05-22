package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.domain.dtos.DomicilioDTO;
import com.example.buensaboruno.domain.entities.Domicilio;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomicilioMapper extends BaseMapper<Domicilio, DomicilioDTO> {
    DomicilioDTO toDTO(Domicilio source);
    Domicilio toEntity(DomicilioDTO source);
    List<DomicilioDTO> toDTOsList(List<Domicilio> source);
    List<Domicilio> toEntitiesList(List<DomicilioDTO> source);
}
