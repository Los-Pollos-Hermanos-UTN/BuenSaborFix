package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.domain.dtos.ArticuloDTO;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.dtos.PromocionDetalleDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.ArticuloManufacturadoShortDTO;
import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.domain.entities.PromocionDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ArticuloInsumoMapper.class, ArticuloManufacturadoMapper.class})
public interface PromocionDetalleMapper  extends BaseMapper<PromocionDetalle, PromocionDetalleDTO> {
    @Mapping(source = "articulo", target = "articulo")
    PromocionDetalleDTO toDTO(PromocionDetalle source);

    @Mapping(source = "articulo", target = "articulo")
    PromocionDetalle toEntity(PromocionDetalleDTO source);

    List<PromocionDetalleDTO> toDTOsList(List<PromocionDetalle> source);
    List<PromocionDetalle> toEntitiesList(List<PromocionDetalleDTO> source);

    default Articulo toEntity(ArticuloDTO articuloDTO) {
        if (articuloDTO instanceof ArticuloInsumoDTO) {
            return toArticuloInsumo((ArticuloInsumoDTO) articuloDTO);
        } else if (articuloDTO instanceof ArticuloManufacturadoDTO) {
            return toArticuloManufacturado((ArticuloManufacturadoDTO) articuloDTO);
        } else {
            throw new IllegalArgumentException("Tipo de ArticuloDTO no soportado: " + articuloDTO.getClass().getName());
        }
    }

    default ArticuloDTO toDTO(Articulo articulo) {
        if (articulo instanceof ArticuloInsumo) {
            return new ArticuloInsumoMapperImpl().toDTO((ArticuloInsumo) articulo);
        } else if (articulo instanceof ArticuloManufacturado) {
            return new ArticuloManufacturadoMapperImpl().toDTO((ArticuloManufacturado) articulo);
        } else {
            throw new IllegalArgumentException("Tipo de Articulo no soportado: " + articulo.getClass().getName());
        }
    }

    ArticuloManufacturado toArticuloManufacturado(ArticuloManufacturadoDTO source);
    ArticuloInsumo toArticuloInsumo(ArticuloInsumoDTO source);
}
