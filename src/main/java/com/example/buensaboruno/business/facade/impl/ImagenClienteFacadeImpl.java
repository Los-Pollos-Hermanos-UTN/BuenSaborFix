package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.ImagenClienteFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.ImagenClienteDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.ImagenCliente;

public class ImagenClienteFacadeImpl extends BaseFacadeImpl<ImagenCliente,ImagenClienteDTO, Long> implements ImagenClienteFacade {
    public ImagenClienteFacadeImpl(BaseService<ImagenCliente, Long> baseService, BaseMapper<ImagenCliente, ImagenClienteDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
