package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.CategoriaFacadeImpl;
import com.example.buensaboruno.business.services.impl.CategoriaServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.CategoriaDTO;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/categoria")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaDTO, Long, CategoriaFacadeImpl> {
    public CategoriaController(CategoriaFacadeImpl facade) {
        super(facade);
    }

    @Autowired
    private CategoriaFacadeImpl categoriaFacadeImpl;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO createdCategoria = categoriaFacadeImpl.createCategoria(categoriaDTO);
        return new ResponseEntity<>(createdCategoria, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaDTO> editCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO editedCategoria = categoriaFacadeImpl.editCategoria(id, categoriaDTO);
        if(editedCategoria != null){
            return new ResponseEntity<>(editedCategoria, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CategoriaDTO>> getAllCategorias() {
        Set<CategoriaDTO> categorias = categoriaFacadeImpl.getAll();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping(value = "/listByEmpresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CategoriaDTO>> listCategoriasByEmpresa(@PathVariable Long id) {
        Set<CategoriaDTO> categoriaDTOS = categoriaFacadeImpl.listCategoriasByEmpresaId(id);
        return new ResponseEntity<>(categoriaDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/listBySucursal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<CategoriaDTO>> listCategoriasBySucursal(@PathVariable Long id) {
        Set<CategoriaDTO> categoriaDTOS = categoriaFacadeImpl.listCategoriasBySucursal(id);
        return new ResponseEntity<>(categoriaDTOS, HttpStatus.OK);
    }
}

