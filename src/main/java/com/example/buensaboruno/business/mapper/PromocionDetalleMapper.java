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

@Mapper(componentModel = "spring", uses = {ArticuloMapper.class})
public interface PromocionDetalleMapper  extends BaseMapper<PromocionDetalle, PromocionDetalleDTO> {

}
