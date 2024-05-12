package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.FacturaFacadeImpl;
import com.example.buensaboruno.domain.dtos.FacturaDTO;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/factura")
public class FacturaController extends BaseControllerImpl<Factura, FacturaDTO, Long, FacturaFacadeImpl> {
    public FacturaController(FacturaFacadeImpl facade){
        super(facade);
    }
}
