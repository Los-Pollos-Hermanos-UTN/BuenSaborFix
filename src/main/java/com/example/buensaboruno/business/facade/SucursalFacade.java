package com.example.buensaboruno.business.facade;

import com.example.buensaboruno.business.facade.base.BaseFacade;
import com.example.buensaboruno.domain.dtos.SucursalDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.EmpresaShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;

public interface SucursalFacade extends BaseFacade<SucursalDTO, Long> {
    SucursalShortDTO getShort(Long id) throws Exception;
}
