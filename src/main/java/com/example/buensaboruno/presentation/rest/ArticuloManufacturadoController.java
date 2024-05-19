package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoFacade;
import com.example.buensaboruno.business.facade.impl.ArticuloManufacturadoFacadeImpl;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articuloManufacturado")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoDTO, Long, ArticuloManufacturadoFacadeImpl> {
    public ArticuloManufacturadoController(ArticuloManufacturadoFacadeImpl facade){
        super(facade);
    }

    @Autowired
    private ArticuloManufacturadoFacadeImpl articuloManufacturadoFacadeImpl;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticuloManufacturadoDTO> createArticuloManufacturado(@RequestBody ArticuloManufacturadoDTO articuloManufacturadoDTO) {
        ArticuloManufacturadoDTO createdArticulo = articuloManufacturadoFacadeImpl.createArticuloManufacturado(articuloManufacturadoDTO);
        return new ResponseEntity<>(createdArticulo, HttpStatus.CREATED);
    }
}
