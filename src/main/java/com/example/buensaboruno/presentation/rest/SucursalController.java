package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.SucursalFacadeImpl;
import com.example.buensaboruno.business.services.impl.ImagenSucursalServiceImpl;
import com.example.buensaboruno.business.services.impl.SucursalServiceImpl;
import com.example.buensaboruno.domain.dtos.ImagenSucursalDTO;
import com.example.buensaboruno.domain.dtos.SucursalDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.EmpresaShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.ImagenSucursal;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import com.example.buensaboruno.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/sucursal")
public class SucursalController extends BaseControllerImpl<Sucursal, SucursalDTO, Long, SucursalFacadeImpl> {
    public SucursalController(SucursalFacadeImpl facade, SucursalRepository sucursalRepository) {
        super(facade);
        this.sucursalRepository = sucursalRepository;
    }

    @Autowired
    private SucursalFacadeImpl sucursalFacade;

    @Autowired
    private ImagenSucursalServiceImpl imagenSucursalService;

    private final SucursalRepository sucursalRepository;

    @GetMapping("/{id}/short")
    public ResponseEntity<SucursalShortDTO> getShort(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facade.getShort(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/short", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SucursalShortDTO> createShort(@RequestBody SucursalShortDTO sucursalShortDTO) {
        try {
            return ResponseEntity.ok(facade.saveShort(sucursalShortDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}/short")
    public ResponseEntity<Void> deleteShort(@PathVariable Long id) {
        try {
            facade.deleteShort(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/short")
    public ResponseEntity<List<SucursalShortDTO>> getAllShort() {
        try {
            return ResponseEntity.ok(facade.findAllShort());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/{id}/short", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SucursalShortDTO> updateShort(@PathVariable Long id, @RequestBody SucursalShortDTO sucursalShortDTO) {
        try {
            return ResponseEntity.ok(facade.updateShort(id, sucursalShortDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/short/listByEmpresa/{id}")
    public ResponseEntity<List<SucursalShortDTO>> getAllShortByEmpresa(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facade.findAllShortByEmpresa(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listByEmpresa/{id}")
    public ResponseEntity<List<SucursalDTO>> getAllByEmpresa(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facade.findAllByEmpresa(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SucursalDTO> createSucursal(
            @RequestPart("data") String sucursalJson,
            @RequestPart("imagenes") MultipartFile file) {

        // Convertir el JSON de sucursal a SucursalDTO
        SucursalDTO sucursalDTO = sucursalFacade.mapperJson(sucursalJson);

        // Subir la imagen y obtener la URL
        String imageUrl = imagenSucursalService.saveImage(file);

        // Verificar si la URL no es nula y asignarla al DTO
        sucursalDTO.setImagenSucursal(new ImagenSucursalDTO(imageUrl));

        // Crear la Sucursal
        SucursalDTO createdSucursal = sucursalFacade.createSucursal(sucursalDTO);

        return new ResponseEntity<>(createdSucursal, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<SucursalDTO> updateSucursal(
            @PathVariable Long id,
            @RequestPart("data") String sucursalJson,
            @RequestPart("imagenes") MultipartFile file) {

        // Convertir el JSON de sucursal a SucursalDTO
        SucursalDTO sucursalDTO = sucursalFacade.mapperJson(sucursalJson);

        // Subir la imagen y obtener la URL
        String imageUrl = imagenSucursalService.saveImage(file);

        // Verificar si la URL no es nula y asignarla al DTO
        sucursalDTO.setImagenSucursal(new ImagenSucursalDTO(imageUrl));

        // Editar la Sucursal
        SucursalDTO updatedSucursal = sucursalFacade.editSucursal(sucursalDTO, id);

        if (updatedSucursal != null) {
            return new ResponseEntity<>(updatedSucursal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

