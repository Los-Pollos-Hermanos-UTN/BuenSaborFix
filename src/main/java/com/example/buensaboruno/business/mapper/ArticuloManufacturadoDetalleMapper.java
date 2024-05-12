package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDetalleDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;

import java.util.List;

public interface ArticuloManufacturadoDetalleMapper extends BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDTO>{
    ArticuloManufacturadoDetalleDTO toDTO(ArticuloManufacturadoDetalle source);
    ArticuloManufacturadoDetalle toEntity(ArticuloManufacturadoDetalleDTO source);
    List<ArticuloManufacturadoDetalleDTO> toDTOsList(List<ArticuloManufacturadoDetalle> source);
    List<ArticuloManufacturadoDetalle> toEntitiesList(List<ArticuloManufacturadoDetalleDTO> source);
}
