package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.domain.dtos.ImagenClienteDTO;
import com.example.buensaboruno.presentation.base.ImagenBaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clienteImages")
public class ImagenClienteController extends ImagenBaseControllerImpl<ImagenClienteDTO> {
}
