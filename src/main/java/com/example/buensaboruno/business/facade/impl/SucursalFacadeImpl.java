package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.SucursalFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.SucursalDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.Sucursal;

public class SucursalFacadeImpl extends BaseFacadeImpl<Sucursal, SucursalDTO, Long> implements SucursalFacade {
    public SucursalFacadeImpl(BaseService<Sucursal, Long> baseService, BaseMapper<Sucursal, SucursalDTO> baseMapper){
        super(baseService, baseMapper);
    }
}