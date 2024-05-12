package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dtos.CategoriaDTO;
import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.domain.entities.Categoria;

import java.util.List;

public interface CategoriaMapper extends BaseMapper<Categoria, CategoriaDTO>{
    CategoriaDTO toDTO(Articulo source);
    Categoria toEntity(CategoriaDTO source);
    List<CategoriaDTO> toDTOsList(List<Categoria> source);
    List<Categoria> toEntitiesList(List<CategoriaDTO> source);
}
