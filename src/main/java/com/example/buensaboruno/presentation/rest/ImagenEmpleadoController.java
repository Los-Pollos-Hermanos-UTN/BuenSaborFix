package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ImagenEmpleadoFacadeImpl;
import com.example.buensaboruno.domain.dtos.ImagenEmpleadoDTO;
import com.example.buensaboruno.domain.entities.ImagenEmpleado;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/imagenEmpleado")
public class ImagenEmpleadoController extends BaseControllerImpl<ImagenEmpleado, ImagenEmpleadoDTO, Long, ImagenEmpleadoFacadeImpl> {
    public ImagenEmpleadoController(ImagenEmpleadoFacadeImpl facade){
        super(facade);
    }
}
