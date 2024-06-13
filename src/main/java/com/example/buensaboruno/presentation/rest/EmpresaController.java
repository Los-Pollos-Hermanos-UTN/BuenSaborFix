package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.EmpresaFacadeImpl;
import com.example.buensaboruno.business.services.impl.ImagenEmpresaServiceImpl;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.ImagenEmpresaDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.EmpresaShortDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import com.example.buensaboruno.repositories.EmpresaRepository;
import com.example.buensaboruno.utils.Autenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/empresa")
public class EmpresaController extends BaseControllerImpl<Empresa, EmpresaDTO, Long, EmpresaFacadeImpl> {
    public EmpresaController(EmpresaFacadeImpl facade, EmpresaRepository empresaRepository) {
        super(facade);
        this.empresaRepository = empresaRepository;
    }

    @Autowired
    private EmpresaFacadeImpl empresaFacade;

    @Autowired
    private ImagenEmpresaServiceImpl imagenEmpresaService;

    @Autowired
    private Autenticator autenticator;

    private final EmpresaRepository empresaRepository;

    @GetMapping("/{id}/short")
    public ResponseEntity<EmpresaShortDTO> getShort(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facade.getShort(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/short")
    public ResponseEntity<EmpresaShortDTO> createShort(@RequestBody EmpresaShortDTO empresaShortDTO) {
        try {
            return ResponseEntity.ok(facade.saveShort(empresaShortDTO));
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
    @PreAuthorize("hasAuthority('admin') || hasAuthority('cocinero') || hasAuthority('cajero') || hasAuthority('delivery')")
    public ResponseEntity<List<EmpresaShortDTO>> getAllShort() {

        try {
            String email = autenticator.getEmail();
            String rol = autenticator.getRole();
            if (!rol.equals("admin")) {
                List<EmpresaShortDTO> empresas = facade.listEmpresasByEmpleadoEmail(email);
                return new ResponseEntity<>(empresas, HttpStatus.OK);
            }
            return ResponseEntity.ok(facade.findAllShort());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/short")
    public ResponseEntity<EmpresaShortDTO> updateShort(@PathVariable Long id, @RequestBody EmpresaShortDTO empresaShortDTO) {
        try {
            return ResponseEntity.ok(facade.updateShort(id, empresaShortDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpresaDTO> createEmpresa(
            @RequestPart("data") String empresaJson,
            @RequestPart("imagenes") MultipartFile[] files) {

        // Convertir el JSON de empresa a empresaDTO
        EmpresaDTO empresaDTO = empresaFacade.mapperJson(empresaJson);

        // Subir la imagen y obtener la URL
        List<String> imageUrls = imagenEmpresaService.saveImages(files);

        // Verificar si la URL no es nula y asignarla al DTO
        empresaDTO.setImagenes(imageUrls.stream()
                .map(url -> new ImagenEmpresaDTO(url))
                .collect(Collectors.toSet()));

        // Crear la Empresa
        EmpresaDTO createdEmpresa = empresaFacade.createEmpresa(empresaDTO);

        return new ResponseEntity<>(createdEmpresa, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpresaDTO> updateEmpresa(
            @PathVariable Long id,
            @RequestPart("data") String empresaJson,
            @RequestPart(value = "imagenes", required = false) MultipartFile[] files) {

        // Convertir el JSON de empresa a empresaDTO
        EmpresaDTO empresaDTO = empresaFacade.mapperJson(empresaJson);

        // Verificar si hay archivos de imagen para subir
        empresaDTO = empresaFacade.uploadImages(empresaDTO, files);

        // Editar la Empresa
        EmpresaDTO updatedEmpresa = empresaFacade.editEmpresa(empresaDTO, id);

        if (updatedEmpresa != null) {
            return new ResponseEntity<>(updatedEmpresa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

