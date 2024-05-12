package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.UnidadMedidaFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.UnidadMedidaDTO;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaFacadeImpl extends BaseFacadeImpl<UnidadMedida, UnidadMedidaDTO, Long> implements UnidadMedidaFacade {
    public UnidadMedidaFacadeImpl(BaseService<UnidadMedida, Long> baseService, BaseMapper<UnidadMedida, UnidadMedidaDTO> baseMapper){
        super(baseService, baseMapper);
    }
}