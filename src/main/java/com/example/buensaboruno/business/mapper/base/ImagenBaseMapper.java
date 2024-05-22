package com.example.buensaboruno.business.mapper.base;

import com.example.buensaboruno.domain.dtos.base.ImagenBaseDTO;
import com.example.buensaboruno.domain.entities.base.ImagenBase;

import java.util.List;

public interface ImagenBaseMapper<E extends ImagenBase, D extends ImagenBaseDTO>{
    D toDTO(E source);
    E toEntity(D source);
    List<D> toDTOsList(List<E> source);
    List<E> toEntitiesList(List<D> source);
}
