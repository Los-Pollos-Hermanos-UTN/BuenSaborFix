package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoFacade;
import com.example.buensaboruno.business.facade.impl.ArticuloManufacturadoFacadeImpl;
import com.example.buensaboruno.business.facade.impl.ImagenArticuloFacadeImpl;
import com.example.buensaboruno.business.services.impl.ImagenArticuloServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articuloManufacturado")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoDTO, Long, ArticuloManufacturadoFacadeImpl> {
    public ArticuloManufacturadoController(ArticuloManufacturadoFacadeImpl facade){
        super(facade);
    }

    @Autowired
    private ArticuloManufacturadoFacadeImpl articuloManufacturadoFacadeImpl;

    @Autowired
    private ImagenArticuloServiceImpl imagenArticuloServiceImpl;

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

    @PostMapping(value = "/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticuloManufacturadoDTO> createArticuloManufacturado(
            @RequestPart("data") String articuloManufacturadoJson,
            @RequestPart("imagenes") MultipartFile[] files) {

        // Convertir el JSON de articuloInsumo a ArticuloInsumoDTO
        ArticuloManufacturadoDTO articuloManufacturadoDTO = articuloManufacturadoFacadeImpl.mapperJson(articuloManufacturadoJson);
        // Subir las imágenes y obtener las URLs
        List<String> imageUrls = imagenArticuloServiceImpl.saveImages(files);
        // Asignar las URLs de las imágenes al DTO
        articuloManufacturadoDTO.setImagenes(imageUrls.stream()
                .map(url -> new ImagenArticuloDTO(url))
                .collect(Collectors.toSet()));

        // Crear el ArticuloInsumo
        ArticuloManufacturadoDTO createdArticulo = articuloManufacturadoFacadeImpl.createArticuloManufacturado(articuloManufacturadoDTO);

        return new ResponseEntity<>(createdArticulo, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticuloManufacturadoDTO> updateArticuloManufacturado(
            @PathVariable Long id,
            @RequestPart("data") String articuloManufacturadoJson,
            @RequestPart(value = "imagenes", required = false) MultipartFile[] files) {

        // Convertir el JSON de articuloInsumo a ArticuloInsumoDTO
        ArticuloManufacturadoDTO articuloManufacturadoDTO = articuloManufacturadoFacadeImpl.mapperJson(articuloManufacturadoJson);


        // Verificar si hay archivos de imagen para subir
        if (files != null && files.length > 0) {

            // Subir las imágenes y obtener las URLs
            List<String> imageUrls = imagenArticuloServiceImpl.saveImages(files);

            // Crear un conjunto de imágenes a partir de las URLs
            Set<ImagenArticuloDTO> nuevasImagenes = imageUrls.stream()
                    .map(url -> new ImagenArticuloDTO(url))
                    .collect(Collectors.toSet());


            // Verificar si articuloManufacturadoDTO ya tiene imágenes
            if (articuloManufacturadoDTO.getImagenes() != null && !articuloManufacturadoDTO.getImagenes().isEmpty()) {
                // Mantener las imágenes existentes y agregar las nuevas
                articuloManufacturadoDTO.getImagenes().addAll(nuevasImagenes);
            } else {
                articuloManufacturadoDTO.setImagenes(nuevasImagenes);
            }
        }

        System.out.println("DTO final antes de guardar: " + articuloManufacturadoDTO);

        // Editar el ArticuloInsumo
        ArticuloManufacturadoDTO updatedArticulo = articuloManufacturadoFacadeImpl.editArticuloManufacturado(articuloManufacturadoDTO, id);

        if (updatedArticulo != null) {
            return new ResponseEntity<>(updatedArticulo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
