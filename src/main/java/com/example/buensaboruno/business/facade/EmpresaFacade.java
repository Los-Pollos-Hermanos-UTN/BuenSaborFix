package com.example.buensaboruno.business.facade;

import com.example.buensaboruno.business.facade.base.BaseFacade;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.EmpresaShortDTO;

public interface EmpresaFacade extends BaseFacade<EmpresaDTO, Long> {
    EmpresaShortDTO getShort(Long id) throws Exception;
}
