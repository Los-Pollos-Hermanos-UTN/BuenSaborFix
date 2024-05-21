package com.example.buensaboruno.presentation.rest;


import com.example.buensaboruno.business.facade.impl.ArticuloInsumoFacadeImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articuloInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoDTO, Long, ArticuloInsumoFacadeImpl> {
    public ArticuloInsumoController(ArticuloInsumoFacadeImpl facade){
        super(facade);
    }

    @Autowired
    private ArticuloInsumoFacadeImpl articuloInsumoFacadeImpl;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticuloInsumoDTO> createArticuloInsumo(@RequestBody ArticuloInsumoDTO articuloInsumoDTO) {
        ArticuloInsumoDTO createdArticulo = articuloInsumoFacadeImpl.createArticuloInsumo(articuloInsumoDTO);
        return new ResponseEntity<>(createdArticulo, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticuloInsumoDTO> editArticuloInsumo(@PathVariable Long id, @RequestBody ArticuloInsumoDTO articuloInsumoDTO) {
        ArticuloInsumoDTO editedArticulo = articuloInsumoFacadeImpl.editArticuloInsumo(articuloInsumoDTO, id);
        if(editedArticulo == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(editedArticulo, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/listByEmpresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArticuloInsumoDTO>> listArticulosInsumoByEmpresa(@PathVariable Long id) {
        List<ArticuloInsumoDTO> articuloInsumoDTOS = articuloInsumoFacadeImpl.findArticuloInsumosByEmpresaId(id);
        return new ResponseEntity<>(articuloInsumoDTOS, HttpStatus.OK);
    }
}
