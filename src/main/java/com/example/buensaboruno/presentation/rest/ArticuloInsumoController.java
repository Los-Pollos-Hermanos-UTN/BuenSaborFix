package com.example.buensaboruno.presentation.rest;


import com.example.buensaboruno.business.services.ArticuloInsumoService;
import com.example.buensaboruno.business.services.impl.ArticuloInsumoServiceImpl;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articuloInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl> {
}
