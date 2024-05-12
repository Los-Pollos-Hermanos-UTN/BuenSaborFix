package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.DetallePedidoDTO;
import com.example.buensaboruno.domain.entities.DetallePedido;

import java.util.List;

public interface DetallePedidoMapper extends BaseMapper<DetallePedido, DetallePedidoDTO>{
    DetallePedidoDTO toDTO(DetallePedido source);
    DetallePedido toEntity(DetallePedidoDTO source);
    List<DetallePedidoDTO> toDTOsList(List<DetallePedido> source);
    List<DetallePedido> toEntitiesList(List<DetallePedidoDTO> source);
}
