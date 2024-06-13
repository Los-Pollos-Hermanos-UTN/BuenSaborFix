package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.domain.dtos.ArticuloDTO;
import com.example.buensaboruno.domain.entities.Articulo;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ImagenArticuloMapper.class, CategoriaMapper.class})
public interface ArticuloMapper extends BaseMapper<Articulo, ArticuloDTO> {

    @Override
    @Mapping(source = "categoriaId", target = "categoria.id")
    Articulo toEntity(ArticuloDTO source);
    @Override
    @Mapping(source = "categoria.id", target = "categoriaId") // Agrega este mapeo
    ArticuloDTO toDTO(Articulo source);

    @Override
    List<ArticuloDTO> toDTOsList(List<Articulo> source);

    @Override
    List<Articulo> toEntitiesList(List<ArticuloDTO> source);

}