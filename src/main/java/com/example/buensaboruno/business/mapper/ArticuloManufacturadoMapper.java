package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.repositories.CategoriaRepository;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDTO> {
    @Override
    @Mapping(source = "categoria.id", target = "categoriaId")
    ArticuloManufacturadoDTO toDTO(ArticuloManufacturado articuloManufacturado);

    @Override
    @Named("basicToEntity")
    ArticuloManufacturado toEntity(ArticuloManufacturadoDTO articuloManufacturadoDTO);

    @Named("toEntityWithContextMapping")
    @Mapping(source = "categoriaId", target = "categoria", qualifiedByName = "mapCategoriaIdToCategoria")
    ArticuloManufacturado toEntityWithContextMapping(ArticuloManufacturadoDTO articuloManufacturadoDTO, @Context CategoriaRepository categoriaRepository);

    @Named("mapCategoriaIdToCategoria")
    default Categoria mapCategoriaIdToCategoria(Long categoriaId, @Context CategoriaRepository categoriaRepository) {
        return categoriaId != null ? categoriaRepository.findById(categoriaId).orElse(null) : null;
    }

    @IterableMapping(qualifiedByName = "basicToEntity")
    List<ArticuloManufacturado> toEntitiesList(List<ArticuloManufacturadoDTO> source);
    List<ArticuloManufacturadoDTO> toDTOsList(List<ArticuloManufacturado> source);
}
