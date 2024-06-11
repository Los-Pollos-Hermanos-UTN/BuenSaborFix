package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ClienteFacadeImpl;
import com.example.buensaboruno.business.facade.impl.EmpleadoFacadeImpl;
import com.example.buensaboruno.business.services.impl.ImagenEmpleadoServiceImpl;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.dtos.EmpleadoDTO;
import com.example.buensaboruno.domain.dtos.ImagenClienteDTO;
import com.example.buensaboruno.domain.dtos.ImagenEmpleadoDTO;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            @RequestPart("imagenes") MultipartFile file) {

        // Convertir el JSON de empleado a empleadoDTO
        EmpleadoDTO empleadoDTO = empleadoFacadeImpl.mapperJson(empleadoJson);
        // Subir las imágenes y obtener las URLs
        String imageUrl = imagenEmpleadoServiceImpl.saveImage(file);
        // Asignar las URLs de las imágenes al DTO
        empleadoDTO.setImagenes(new ImagenEmpleadoDTO(imageUrl));

        // Crear al empleado
        EmpleadoDTO createdEmpleado = empleadoFacadeImpl.createEmpleado(empleadoDTO);

        return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDTO> updateEmpleado(
            @PathVariable Long id,
            @RequestPart("data") String empleadoJson,
            @RequestPart(value = "imagenes", required = false) MultipartFile file) {

        // Convertir el JSON de empleado a empleadoDTO
        EmpleadoDTO empleadoDTO = empleadoFacadeImpl.mapperJson(empleadoJson);

        // Subir la imagen y obtener la URL
        if(empleadoDTO.getImagenes() != null || empleadoDTO.getImagenes().getUrl().isEmpty()){
            String imageUrl = imagenEmpleadoServiceImpl.saveImage(file);

            // Verificar si la URL no es nula y asignarla al DTO
            empleadoDTO.setImagenes(new ImagenEmpleadoDTO(imageUrl));
        }

        // Editar al Empleado
        EmpleadoDTO updatedEmpleado = empleadoFacadeImpl.editEmpleado(empleadoDTO, id);

        if (updatedEmpleado != null) {
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
