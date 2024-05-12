package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.DetallePedidoFacade;
import com.example.buensaboruno.business.facade.DomicilioFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.DetallePedidoDTO;
import com.example.buensaboruno.domain.dtos.DomicilioDTO;
import com.example.buensaboruno.domain.entities.DetallePedido;
import com.example.buensaboruno.domain.entities.Domicilio;

public class DomicilioFacadeImpl extends BaseFacadeImpl<Domicilio, DomicilioDTO, Long> implements DomicilioFacade {
    public DomicilioFacadeImpl(BaseService<Domicilio, Long> baseService, BaseMapper<Domicilio, DomicilioDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
