package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.PromocionDetalleFacadeImpl;
import com.example.buensaboruno.business.facade.impl.PromocionFacadeImpl;
import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.dtos.PromocionDetalleDTO;
import com.example.buensaboruno.domain.entities.Promocion;
import com.example.buensaboruno.domain.entities.PromocionDetalle;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/promocionDetalle")
public class PromocionDetalleController extends BaseControllerImpl<PromocionDetalle, PromocionDetalleDTO, Long, PromocionDetalleFacadeImpl> {
    public PromocionDetalleController(PromocionDetalleFacadeImpl facade){
        super(facade);
    }
}
