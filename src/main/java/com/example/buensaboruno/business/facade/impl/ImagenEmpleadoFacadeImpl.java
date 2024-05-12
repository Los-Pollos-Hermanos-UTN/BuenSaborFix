package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.ImagenEmpleadoFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.ImagenEmpleadoDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.ImagenEmpleado;

public class ImagenEmpleadoFacadeImpl extends BaseFacadeImpl<ImagenEmpleado, ImagenEmpleadoDTO, Long> implements ImagenEmpleadoFacade {
    public ImagenEmpleadoFacadeImpl(BaseService<ImagenEmpleado, Long> baseService, BaseMapper<ImagenEmpleado, ImagenEmpleadoDTO> baseMapper){
        super(baseService, baseMapper);
    }
}