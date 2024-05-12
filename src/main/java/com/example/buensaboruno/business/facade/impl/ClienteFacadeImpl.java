package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ClienteFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteFacadeImpl extends BaseFacadeImpl<Cliente, ClienteDTO, Long> implements ClienteFacade {
    public ClienteFacadeImpl(BaseService<Cliente, Long> baseService, BaseMapper<Cliente, ClienteDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
