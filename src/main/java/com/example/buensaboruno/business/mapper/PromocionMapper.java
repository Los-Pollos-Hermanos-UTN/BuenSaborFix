package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.domain.dtos.ArticuloDTO;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.domain.entities.Promocion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PromocionDetalleMapper.class, SucursalMapper.class, ImagenArticuloMapper.class})
public interface PromocionMapper  extends BaseMapper<Promocion, PromocionDTO> {

    @Override
    @Mapping(source = "promocionDetalles", target = "promocionDetalles")
    @Mapping(source = "imagenes", target = "imagenes")
    @Mapping(source = "sucursales", target = "sucursales")
    PromocionDTO toDTO(Promocion source);

    @Override
    @Mapping(source = "promocionDetalles", target = "promocionDetalles")
    @Mapping(source = "imagenes", target = "imagenes")
    @Mapping(source = "sucursales", target = "sucursales")
    Promocion toEntity(PromocionDTO source);

    List<PromocionDTO> toDTOsList(List<Promocion> source);
    List<Promocion> toEntitiesList(List<PromocionDTO> source);

    default Articulo toEntity(ArticuloDTO articuloDTO) {
        if (articuloDTO instanceof ArticuloInsumoDTO) {
            return new ArticuloInsumoMapperImpl().toEntity((ArticuloInsumoDTO) articuloDTO);
        } else if (articuloDTO instanceof ArticuloManufacturadoDTO) {
            return new ArticuloManufacturadoMapperImpl().toEntity((ArticuloManufacturadoDTO) articuloDTO);
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
}
