package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.PaisFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.PaisDTO;
import com.example.buensaboruno.domain.entities.Pais;
import org.springframework.stereotype.Service;

@Service
public class PaisFacadeImpl extends BaseFacadeImpl<Pais, PaisDTO, Long> implements PaisFacade {
    public PaisFacadeImpl(BaseService<Pais, Long> baseService, BaseMapper<Pais, PaisDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
