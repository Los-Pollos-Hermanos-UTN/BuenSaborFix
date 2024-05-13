package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ArticuloInsumoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.articuloDTO.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoFacadeImpl extends BaseFacadeImpl<ArticuloInsumo, ArticuloInsumoDTO, Long> implements ArticuloInsumoFacade {
    public ArticuloInsumoFacadeImpl(BaseService<ArticuloInsumo, Long> baseService, BaseMapper<ArticuloInsumo, ArticuloInsumoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}

