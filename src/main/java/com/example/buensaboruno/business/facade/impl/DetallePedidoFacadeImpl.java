package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ClienteFacade;
import com.example.buensaboruno.business.facade.DetallePedidoFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.dtos.DetallePedidoDTO;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.DetallePedido;

public class DetallePedidoFacadeImpl extends BaseFacadeImpl<DetallePedido, DetallePedidoDTO, Long> implements DetallePedidoFacade {
    public DetallePedidoFacadeImpl(BaseService<DetallePedido, Long> baseService, BaseMapper<DetallePedido, DetallePedidoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
