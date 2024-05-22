package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.domain.dtos.ImagenPromocionDTO;
import com.example.buensaboruno.presentation.base.ImagenBaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/promocionImages")
public class ImagenPromocionController extends ImagenBaseControllerImpl<ImagenPromocionDTO> {
}
