package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.ClienteFacadeImpl;
import com.example.buensaboruno.business.services.impl.ClienteServiceImpl;
import com.example.buensaboruno.business.services.impl.ImagenClienteServiceImpl;
import com.example.buensaboruno.domain.dtos.*;
import com.example.buensaboruno.domain.entities.Cliente;
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
@RequestMapping(path = "/cliente")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteDTO, Long, ClienteFacadeImpl> {
    public ClienteController(ClienteFacadeImpl facade){
        super(facade);
    }

    @Autowired
    private ClienteFacadeImpl clienteFacadeImpl;

    @Autowired
    private ImagenClienteServiceImpl imagenClienteServiceImpl;

    @PostMapping(value = "/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> createCliente(
            @RequestPart("data") String clienteJson,
            @RequestPart(value = "imagenes", required = false) MultipartFile file) {


        // Convertir el JSON de articuloInsumo a ArticuloInsumoDTO
        ClienteDTO clienteDTO = clienteFacadeImpl.mapperJson(clienteJson);
        // Subir las imágenes y obtener las URLs
        String imageUrl = imagenClienteServiceImpl.saveImage(file);
        // Asignar las URLs de las imágenes al DTO
        clienteDTO.setImagenCliente(new ImagenClienteDTO(imageUrl));

        // Crear el Cliente
        ClienteDTO createdCliente = clienteFacadeImpl.createCliente(clienteDTO);

        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String email, @RequestBody String contrasenia) {
        ClienteDTO clienteDTO = clienteFacadeImpl.login(email, contrasenia);
        if(clienteDTO != null){
            return new ResponseEntity<>(clienteDTO, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("La contraseña o el mail son incorrectos", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/edit/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> updateEmpresa(
            @PathVariable Long id,
            @RequestPart("data") String clienteJson,
            @RequestPart(value = "imagenes", required = false) MultipartFile file) {

        // Convertir el JSON de cliente a clienteDTO
        ClienteDTO clienteDTO = clienteFacadeImpl.mapperJson(clienteJson);

        // Subir la imagen y obtener la URL
        if(clienteDTO.getImagenCliente() != null || clienteDTO.getImagenCliente().getUrl().isEmpty()){
            String imageUrl = imagenClienteServiceImpl.saveImage(file);

            // Verificar si la URL no es nula y asignarla al DTO
            clienteDTO.setImagenCliente(new ImagenClienteDTO(imageUrl));
        }

        // Editar el Cliente
        ClienteDTO updatedCliente = clienteFacadeImpl.editCliente(clienteDTO, id);

        if (updatedCliente != null) {
            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
