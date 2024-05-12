package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ArticuloDTO;
import com.example.buensaboruno.domain.entities.Articulo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloMapper extends BaseMapper<Articulo, ArticuloDTO>{
    ArticuloDTO toDTO(Articulo source);
    Articulo toEntity(ArticuloDTO source);
    List<ArticuloDTO> toDTOsList(List<Articulo> source);
    List<Articulo> toEntitiesList(List<ArticuloDTO> source);
}
