package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoDTO>{
    ArticuloInsumoDTO toDTO(ArticuloInsumo source);
    ArticuloInsumo toEntity(ArticuloInsumoDTO source);
    List<ArticuloInsumoDTO> toDTOsList(List<ArticuloInsumo> source);
    List<ArticuloInsumo> toEntitiesList(List<ArticuloInsumoDTO> source);
}
