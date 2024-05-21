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

import java.util.List;

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

    @PutMapping(value = "/edit/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticuloManufacturadoDTO> editArticuloManufacturado(@PathVariable Long id, @RequestBody ArticuloManufacturadoDTO articuloManufacturadoDTO) {
        ArticuloManufacturadoDTO editedArticulo = articuloManufacturadoFacadeImpl.editArticuloManufacturado(articuloManufacturadoDTO, id);
        if(editedArticulo == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(editedArticulo, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/listByEmpresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArticuloManufacturadoDTO>> listArticulosManufacturadosByEmpresa(@PathVariable Long id) {
        List<ArticuloManufacturadoDTO> articuloManufacturadoDTOS = articuloManufacturadoFacadeImpl.findArticuloManufacturadosByEmpresaId(id);
        return new ResponseEntity<>(articuloManufacturadoDTOS, HttpStatus.OK);
    }
}
