package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.domain.dtos.PromocionDetalleDTO;
import com.example.buensaboruno.domain.entities.PromocionDetalle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PromocionDetalleMapper  extends BaseMapper<PromocionDetalle, PromocionDetalleDTO> {
    PromocionDetalleDTO toDTO(PromocionDetalle source);
    PromocionDetalle toEntity(PromocionDetalleDTO source);
    List<PromocionDetalleDTO> toDTOsList(List<PromocionDetalle> source);
    List<PromocionDetalle> toEntitiesList(List<PromocionDetalleDTO> source);
}
