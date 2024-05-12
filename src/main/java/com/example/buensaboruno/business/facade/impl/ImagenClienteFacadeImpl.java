package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenClienteFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.ImagenClienteDTO;
import com.example.buensaboruno.domain.entities.ImagenCliente;
import org.springframework.stereotype.Service;

@Service
public class ImagenClienteFacadeImpl extends BaseFacadeImpl<ImagenCliente,ImagenClienteDTO, Long> implements ImagenClienteFacade {
    public ImagenClienteFacadeImpl(BaseService<ImagenCliente, Long> baseService, BaseMapper<ImagenCliente, ImagenClienteDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
