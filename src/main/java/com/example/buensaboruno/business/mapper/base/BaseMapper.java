package com.example.buensaboruno.business.mapper.base;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.entities.base.Base;

import java.util.List;

public interface BaseMapper<E extends Base, D extends BaseDTO> {
    D toDTO(E source);
    E toEntity(D source);
    List<D> toDTOsList(List<E> source);
    List<E> toEntitiesList(List<D> source);
}