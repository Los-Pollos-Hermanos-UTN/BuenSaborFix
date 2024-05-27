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

@Mapper(componentModel = "spring", uses = {ArticuloMapper.class, SucursalMapper.class})
public interface PromocionMapper extends BaseMapper<Promocion, PromocionDTO> {
    @Override
    Promocion toEntity(PromocionDTO source);

    @Override
    PromocionDTO toDTO(Promocion source);

    List<Promocion> toEntitiesList(List<PromocionDTO> source);
    List<PromocionDTO> toDTOsList(List<Promocion> source);
}