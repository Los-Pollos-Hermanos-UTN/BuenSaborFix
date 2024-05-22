package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.presentation.base.ImagenBaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/articuloImages")
public class ImagenArticuloController extends ImagenBaseControllerImpl<ImagenArticuloDTO> {
}
