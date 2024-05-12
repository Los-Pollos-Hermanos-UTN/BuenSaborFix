package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.DetallePedidoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.DetallePedidoDTO;
import com.example.buensaboruno.domain.entities.DetallePedido;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoFacadeImpl extends BaseFacadeImpl<DetallePedido, DetallePedidoDTO, Long> implements DetallePedidoFacade {
    public DetallePedidoFacadeImpl(BaseService<DetallePedido, Long> baseService, BaseMapper<DetallePedido, DetallePedidoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
