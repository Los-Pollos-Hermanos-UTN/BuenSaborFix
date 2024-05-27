package com.example.buensaboruno.business.mapper;


import com.example.buensaboruno.business.mapper.base.BaseMapper;
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
import java.util.Set;

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



    ArticuloManufacturado toArticuloManufacturado(ArticuloManufacturadoDTO source);
    ArticuloInsumo toArticuloInsumo(ArticuloInsumoDTO source);
    Set<CategoriaDTO> toDTOsList(Set<Categoria> source);
    List<Categoria> toEntitiesList(List<CategoriaDTO> source);
}
