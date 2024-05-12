package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.PaisFacadeImpl;
import com.example.buensaboruno.domain.dtos.PaisDTO;
import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pais")
public class PaisController extends BaseControllerImpl<Pais, PaisDTO, Long, PaisFacadeImpl> {
    public PaisController(PaisFacadeImpl facade){
        super(facade);
    }
}
