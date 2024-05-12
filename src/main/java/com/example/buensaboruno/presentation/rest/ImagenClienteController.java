package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ImagenArticuloFacadeImpl;
import com.example.buensaboruno.business.facade.impl.ImagenClienteFacadeImpl;
import com.example.buensaboruno.domain.dtos.ImagenClienteDTO;
import com.example.buensaboruno.domain.entities.ImagenCliente;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/imagenCliente")
public class ImagenClienteController extends BaseControllerImpl<ImagenCliente, ImagenClienteDTO, Long, ImagenClienteFacadeImpl> {
    public ImagenClienteController(ImagenClienteFacadeImpl facade){
        super(facade);
    }
}
