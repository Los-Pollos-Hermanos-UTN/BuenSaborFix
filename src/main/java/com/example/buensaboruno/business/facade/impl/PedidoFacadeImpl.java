package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.PedidoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.PedidoDTO;
import com.example.buensaboruno.domain.entities.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoFacadeImpl extends BaseFacadeImpl<Pedido, PedidoDTO, Long> implements PedidoFacade {
    public PedidoFacadeImpl(BaseService<Pedido, Long> baseService, BaseMapper<Pedido, PedidoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
