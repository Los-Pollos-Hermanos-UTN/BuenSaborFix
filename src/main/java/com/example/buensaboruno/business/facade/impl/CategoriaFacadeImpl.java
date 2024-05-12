package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.CategoriaFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.CategoriaDTO;
import com.example.buensaboruno.domain.entities.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaFacadeImpl extends BaseFacadeImpl<Categoria, CategoriaDTO, Long> implements CategoriaFacade {
    public CategoriaFacadeImpl(BaseService<Categoria, Long> baseService, BaseMapper<Categoria, CategoriaDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
