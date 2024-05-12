package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.UnidadMedidaFacadeImpl;
import com.example.buensaboruno.domain.dtos.UnidadMedidaDTO;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/unidadMedida")
public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaDTO, Long, UnidadMedidaFacadeImpl> {
    public UnidadMedidaController(UnidadMedidaFacadeImpl facade){
        super(facade);
    }
}
