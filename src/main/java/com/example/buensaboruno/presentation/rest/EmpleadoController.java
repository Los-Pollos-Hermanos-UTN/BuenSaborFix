package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ClienteFacadeImpl;
import com.example.buensaboruno.business.facade.impl.EmpleadoFacadeImpl;
import com.example.buensaboruno.business.services.impl.ImagenEmpleadoServiceImpl;
import com.example.buensaboruno.domain.dtos.*;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/empleado")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoDTO, Long, EmpleadoFacadeImpl> {
    public EmpleadoController(EmpleadoFacadeImpl facade){
        super(facade);
    }


    @Autowired
    private EmpleadoFacadeImpl empleadoFacadeImpl;

    @Autowired
    private ImagenEmpleadoServiceImpl imagenEmpleadoServiceImpl;


    @PostMapping(value = "/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDTO> createEmpleado(
            @RequestPart("data") String empleadoJson,
            @RequestPart("imagenes") MultipartFile[] files) {

        // Convertir el JSON de empleado a empleadoDTO
        EmpleadoDTO empleadoDTO = empleadoFacadeImpl.mapperJson(empleadoJson);
        // Subir las imágenes y obtener las URLs
        List<String> imagesUrl = imagenEmpleadoServiceImpl.saveImages(files);
        // Asignar las URLs de las imágenes al DTO
        empleadoDTO.setImagenes(imagesUrl.stream()
                .map(url -> new ImagenEmpleadoDTO(url))
                .collect(Collectors.toSet()));

        // Crear al empleado
        EmpleadoDTO createdEmpleado = empleadoFacadeImpl.createEmpleado(empleadoDTO);

        return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDTO> updateEmpleado(
            @PathVariable Long id,
            @RequestPart("data") String empleadoJson,
            @RequestPart(value = "imagenes", required = false) MultipartFile[] files) {

        // Convertir el JSON de empleado a empleadoDTO
        EmpleadoDTO empleadoDTO = empleadoFacadeImpl.mapperJson(empleadoJson);

        // Verificar si hay archivos de imagen para subir
        empleadoDTO = empleadoFacadeImpl.uploadImages(empleadoDTO, files);

        // Editar al Empleado
        EmpleadoDTO updatedEmpleado = empleadoFacadeImpl.editEmpleado(empleadoDTO, id);

        if (updatedEmpleado != null) {
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
