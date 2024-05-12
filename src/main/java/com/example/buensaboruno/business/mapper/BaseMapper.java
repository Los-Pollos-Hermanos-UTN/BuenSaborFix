package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.BaseDTO;
import com.example.buensaboruno.domain.entities.Base;

import java.util.List;

public interface BaseMapper<E extends Base,D extends BaseDTO>{
    D toDTO(E source);
    E toEntity(D source);
    List<D> toDTOsList(List<E> source);
    List<E> toEntitiesList(List<D> source);
}
