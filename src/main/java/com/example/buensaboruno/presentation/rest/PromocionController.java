package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.PromocionFacadeImpl;
import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.entities.Promocion;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/promocion")
public class PromocionController extends BaseControllerImpl<Promocion, PromocionDTO, Long, PromocionFacadeImpl> {
    public PromocionController(PromocionFacadeImpl facade){
        super(facade);
    }
    @Autowired
    private PromocionFacadeImpl promocionFacadeImpl;
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PromocionDTO> createPromocion(@RequestBody PromocionDTO promocionDTO) {

            PromocionDTO createdPromocion = promocionFacadeImpl.createPromocion(promocionDTO);
            return new ResponseEntity<>(createdPromocion, HttpStatus.CREATED);

    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PromocionDTO> editPromocion(@PathVariable Long id, @RequestBody PromocionDTO promocionDTO) {

            PromocionDTO editedPromocion = promocionFacadeImpl.editPromocion(id, promocionDTO);
            return new ResponseEntity<>(editedPromocion, HttpStatus.OK);

    }
}
