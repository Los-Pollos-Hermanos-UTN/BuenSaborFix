package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.UnidadMedidaDTO;
import com.example.buensaboruno.domain.entities.UnidadMedida;

import java.util.List;

public interface UnidadMedidaMapper  extends BaseMapper<UnidadMedida, UnidadMedidaDTO>{
    UnidadMedidaDTO toDTO(UnidadMedida source);
    UnidadMedida toEntity(UnidadMedidaDTO source);
    List<UnidadMedidaDTO> toDTOsList(List<UnidadMedida> source);
    List<UnidadMedida> toEntitiesList(List<UnidadMedidaDTO> source);
}
