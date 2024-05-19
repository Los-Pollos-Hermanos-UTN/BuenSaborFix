package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.repositories.CategoriaRepository;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoDTO> {
    @Override
    @Mapping(source = "categoria.id", target = "categoriaId")
    ArticuloInsumoDTO toDTO(ArticuloInsumo articuloInsumo);

    @Override
    @Named("basicToEntity")
    ArticuloInsumo toEntity(ArticuloInsumoDTO articuloInsumoDTO);

    @Named("toEntityWithContextMapping")
    @Mapping(source = "categoriaId", target = "categoria", qualifiedByName = "mapCategoriaIdToCategoria")
    ArticuloInsumo toEntityWithContextMapping(ArticuloInsumoDTO articuloInsumoDTO, @Context CategoriaRepository categoriaRepository);

    @Named("mapCategoriaIdToCategoria")
    default Categoria mapCategoriaIdToCategoria(Long categoriaId, @Context CategoriaRepository categoriaRepository) {
        return categoriaId != null ? categoriaRepository.findById(categoriaId).orElse(null) : null;
    }

    @IterableMapping(qualifiedByName = "basicToEntity")
    List<ArticuloInsumo> toEntitiesList(List<ArticuloInsumoDTO> source);
    List<ArticuloInsumoDTO> toDTOsList(List<ArticuloInsumo> source);
}
