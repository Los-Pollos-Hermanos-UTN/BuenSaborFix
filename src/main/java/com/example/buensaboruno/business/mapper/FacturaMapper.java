package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.FacturaDTO;
import com.example.buensaboruno.domain.entities.Factura;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturaMapper extends BaseMapper<Factura, FacturaDTO>{
    FacturaDTO toDTO(Factura source);
    Factura toEntity(FacturaDTO source);
    List<FacturaDTO> toDTOsList(List<Factura> source);
    List<Factura> toEntitiesList(List<FacturaDTO> source);
}