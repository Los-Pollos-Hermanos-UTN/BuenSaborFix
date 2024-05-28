package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ImagenSucursalFacade;
import com.example.buensaboruno.business.facade.base.ImagenBaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ImagenSucursalMapper;
import com.example.buensaboruno.business.services.ImagenSucursalService;
import com.example.buensaboruno.domain.dtos.ImagenSucursalDTO;
import com.example.buensaboruno.domain.entities.ImagenSucursal;
import org.springframework.stereotype.Component;

@Component
public class ImagenSucursalFacadeImpl extends ImagenBaseFacadeImpl<ImagenSucursal, ImagenSucursalDTO> implements ImagenSucursalFacade {

    public ImagenSucursalFacadeImpl(ImagenSucursalService service, ImagenSucursalMapper mapper){
        super(service, mapper);
    }
}
