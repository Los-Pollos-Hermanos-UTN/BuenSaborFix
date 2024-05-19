package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.domain.dtos.ArticuloDTO;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.dtos.CategoriaDTO;
import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.repositories.CategoriaRepository;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SucursalMapper.class})
public interface CategoriaMapper extends BaseMapper<Categoria, CategoriaDTO> {

    @Override
    @Mapping(source = "padre.id", target = "padreId")
    CategoriaDTO toDTO(Categoria categoria);

    @Named("toEntityWithContextMapping")
    @Mapping(source = "padreId", target = "padre", qualifiedByName = "mapPadreIdToCategoria")
    Categoria toEntityWithContextMapping(CategoriaDTO categoriaDTO, @Context CategoriaRepository categoriaRepository);

    @Named("mapPadreIdToCategoria")
    default Categoria mapPadreIdToCategoria(Long padreId, @Context CategoriaRepository categoriaRepository) {
        return padreId != null ? categoriaRepository.findById(padreId).orElse(null) : null;
    }

    default Articulo toArticulo(ArticuloDTO source) {
        if (source instanceof ArticuloManufacturadoDTO) {
            return toArticuloManufacturado((ArticuloManufacturadoDTO) source);
        } else if (source instanceof ArticuloInsumoDTO) {
            return toArticuloInsumo((ArticuloInsumoDTO) source);
        } else {
            throw new IllegalArgumentException("Unknown Articulo type");
        }
    }

    ArticuloManufacturado toArticuloManufacturado(ArticuloManufacturadoDTO source);
    ArticuloInsumo toArticuloInsumo(ArticuloInsumoDTO source);
    List<CategoriaDTO> toDTOsList(List<Categoria> source);
    List<Categoria> toEntitiesList(List<CategoriaDTO> source);
}
