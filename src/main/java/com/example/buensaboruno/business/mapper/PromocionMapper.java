package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.entities.Promocion;

import java.util.List;

public interface PromocionMapper  extends BaseMapper<Promocion, PromocionDTO>{
    PromocionDTO toDTO(Promocion source);
    Promocion toEntity(PromocionDTO source);
    List<PromocionDTO> toDTOsList(List<Promocion> source);
    List<Promocion> toEntitiesList(List<PromocionDTO> source);
}
