package com.example.buensaboruno.business.services.base;

import com.example.buensaboruno.domain.entities.base.Base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;

    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(ID id, E entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public List<E> findAllNotDeleted() throws Exception;
}
