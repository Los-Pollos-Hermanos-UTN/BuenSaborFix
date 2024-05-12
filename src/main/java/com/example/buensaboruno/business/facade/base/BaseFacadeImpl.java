package com.example.buensaboruno.business.facade.base;

import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.BaseDTO;
import com.example.buensaboruno.domain.entities.Base;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseFacadeImpl<E extends Base,D extends BaseDTO,ID extends Serializable> implements BaseFacade<D,ID> {

    protected BaseService<E,ID> baseService;
    protected BaseMapper<E,D> baseMapper;

    public BaseFacadeImpl(BaseService<E,ID> baseService, BaseMapper<E,D> baseMapper) {
        this.baseService = baseService;
        this.baseMapper = baseMapper;
    }

    @Override
    @Transactional
    public List<D> findAll() throws Exception {
        try{
            var entities = baseService.findAll();
            return entities
                    .stream()
                    .map(baseMapper::toDTO)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public D findById(ID id) throws Exception {
        try{
            var entity = baseService.findById(id);
            return baseMapper.toDTO(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public D save(D request) throws Exception {
        try {
            var entityToCreate = baseMapper.toEntity(request);
            var entityCreated = baseService.save(entityToCreate);
            return baseMapper.toDTO(entityCreated);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public D update(ID id, D request) throws Exception {
        try{
            var entityToUpdate = baseMapper.toEntity(request);
            var entityUpdated = baseService.update(id, entityToUpdate);
            return baseMapper.toDTO(entityUpdated);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            //Agregar estructura else-if como en el service
            var entity = baseService.findById(id);
            baseService.delete(id);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
