package com.example.buensaboruno.business.facade;

import com.example.buensaboruno.business.facade.base.BaseFacade;
import com.example.buensaboruno.domain.dtos.LocalidadDTO;
import com.example.buensaboruno.domain.entities.Localidad;
import com.example.buensaboruno.domain.entities.Provincia;

import java.util.Optional;

public interface LocalidadFacade extends BaseFacade<LocalidadDTO, Long> {
}
