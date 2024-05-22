package com.example.buensaboruno.presentation.rest;


import com.example.buensaboruno.business.facade.impl.ArticuloInsumoFacadeImpl;
import com.example.buensaboruno.business.services.impl.ImagenArticuloServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articuloInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoDTO, Long, ArticuloInsumoFacadeImpl> {
    public ArticuloInsumoController(ArticuloInsumoFacadeImpl facade,
                                    ArticuloInsumoRepository articuloInsumoRepository){
        super(facade);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }

    @Autowired
    private ArticuloInsumoFacadeImpl articuloInsumoFacadeImpl;

    @Autowired
    private ImagenArticuloServiceImpl imagenArticuloServiceImpl;

    private final ArticuloInsumoRepository articuloInsumoRepository;



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

    @PostMapping(value = "/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticuloInsumoDTO> createArticuloInsumo(
            @RequestPart("articuloInsumo") String articuloInsumoJson,
            @RequestPart("imagen") MultipartFile[] files) {

        // Convertir el JSON de articuloInsumo a ArticuloInsumoDTO
        ArticuloInsumoDTO articuloInsumoDTO = articuloInsumoFacadeImpl.mapperJson(articuloInsumoJson);
        // Subir las imágenes y obtener las URLs
        List<String> imageUrls = imagenArticuloServiceImpl.saveImages(files);
        // Asignar las URLs de las imágenes al DTO
        articuloInsumoDTO.setImagenes(imageUrls.stream()
                .map(url -> new ImagenArticuloDTO(url))
                .collect(Collectors.toSet()));

        // Crear el ArticuloInsumo
        ArticuloInsumoDTO createdArticulo = articuloInsumoFacadeImpl.createArticuloInsumo(articuloInsumoDTO);

        return new ResponseEntity<>(createdArticulo, HttpStatus.CREATED);
    }

}
