package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.FacturaFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.FacturaDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.Factura;

public class FacturaFacadeImpl extends BaseFacadeImpl<Factura, FacturaDTO, Long> implements FacturaFacade {
    public FacturaFacadeImpl(BaseService<Factura, Long> baseService, BaseMapper<Factura, FacturaDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
