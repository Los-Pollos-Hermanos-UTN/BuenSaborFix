package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDTO>{
    ArticuloManufacturadoDTO toDTO(ArticuloManufacturado source);
    ArticuloManufacturado toEntity(ArticuloManufacturadoDTO source);
    List<ArticuloManufacturadoDTO> toDTOsList(List<ArticuloManufacturado> source);
    List<ArticuloManufacturado> toEntitiesList(List<ArticuloManufacturadoDTO> source);
}
