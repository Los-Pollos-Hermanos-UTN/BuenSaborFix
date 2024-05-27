package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.PromocionFacadeImpl;
import com.example.buensaboruno.business.services.impl.ImagenPromocionServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.domain.dtos.ImagenPromocionDTO;
import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import com.example.buensaboruno.domain.entities.Promocion;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/promocion")
public class PromocionController extends BaseControllerImpl<Promocion, PromocionDTO, Long, PromocionFacadeImpl> {

    @Autowired
    private PromocionFacadeImpl promocionFacadeImpl;

    @Autowired
    private ImagenPromocionServiceImpl imagenPromocionServiceImpl;

    public PromocionController(PromocionFacadeImpl facade) {
        super(facade);
    }

    @PostMapping(value = "/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PromocionDTO> createPromocion(
            @RequestPart("data") String promocionJson,
            @RequestPart("imagenes") MultipartFile[] files) {

        // Convertir el JSON de promocion a PromocionDTO
        PromocionDTO promocionDTO = promocionFacadeImpl.mapperJson(promocionJson);

        if (promocionDTO == null) {
            // Manejar el caso en que el mapeo falle
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Subir las imágenes y obtener las URLs
        List<String> imageUrls = imagenPromocionServiceImpl.saveImages(files);

        // Asignar las URLs de las imágenes al DTO
        promocionDTO.setImagenes(imageUrls.stream()
                .map(url -> new ImagenPromocionDTO(url))
                .collect(Collectors.toSet()));

        // Crear la Promocion
        PromocionDTO createdPromocion = promocionFacadeImpl.createPromocion(promocionDTO);

        return new ResponseEntity<>(createdPromocion, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PromocionDTO> editPromocion(
            @PathVariable Long id,
            @RequestPart("data") String promocionJson,
            @RequestPart("imagenes") MultipartFile[] files) {

        // Convertir el JSON de promocion a PromocionDTO
        PromocionDTO promocionDTO = promocionFacadeImpl.mapperJson(promocionJson);

        if (promocionDTO == null) {
            // Manejar el caso en que el mapeo falle
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Subir las imágenes y obtener las URLs
        List<String> imageUrls = imagenPromocionServiceImpl.saveImages(files);

        // Asignar las URLs de las imágenes al DTO
        promocionDTO.setImagenes(imageUrls.stream()
                .map(url -> new ImagenPromocionDTO(url))
                .collect(Collectors.toSet()));

        // Crear la Promocion
        PromocionDTO editedPromocion = promocionFacadeImpl.editPromocion(id, promocionDTO);

        return new ResponseEntity<>(editedPromocion, HttpStatus.CREATED);
    }

}