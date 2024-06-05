package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenEmpresaFacade;
import com.example.buensaboruno.business.facade.base.ImagenBaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ImagenEmpresaMapper;
import com.example.buensaboruno.business.services.ImagenEmpresaService;
import com.example.buensaboruno.domain.dtos.ImagenEmpresaDTO;
import com.example.buensaboruno.domain.entities.ImagenEmpresa;
import org.springframework.stereotype.Component;

@Component
public class ImagenEmpresaFacadeImpl extends ImagenBaseFacadeImpl<ImagenEmpresa, ImagenEmpresaDTO> implements ImagenEmpresaFacade {

    public ImagenEmpresaFacadeImpl(ImagenEmpresaService service, ImagenEmpresaMapper mapper){
        super(service, mapper);
    }
}
