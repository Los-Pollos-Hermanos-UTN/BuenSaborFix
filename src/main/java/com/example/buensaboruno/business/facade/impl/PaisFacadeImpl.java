package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.PaisFacade;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.BaseService;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.PaisDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.domain.entities.Pais;

public class PaisFacadeImpl extends BaseFacadeImpl<Pais, PaisDTO, Long> implements PaisFacade {
    public PaisFacadeImpl(BaseService<Pais, Long> baseService, BaseMapper<Pais, PaisDTO> baseMapper){
        super(baseService, baseMapper);
    }
}
