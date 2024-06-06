package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.UsuarioClienteFacadeImpl;
import com.example.buensaboruno.business.services.impl.UsuarioClienteServiceImpl;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.dtos.UsuarioClienteDTO;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/usuarioCliente")
public class UsuarioClienteController extends BaseControllerImpl<UsuarioCliente, UsuarioClienteDTO, Long, UsuarioClienteFacadeImpl> {

    @Autowired
    private UsuarioClienteFacadeImpl usuarioClienteFacade;
    public UsuarioClienteController(UsuarioClienteFacadeImpl facade){
        super(facade);
    }
    @GetMapping("/{id}/cliente")
    public ResponseEntity<ClienteDTO> getClienteByUsuario(@PathVariable Long id) {
        ClienteDTO clienteDTO = usuarioClienteFacade.getClienteByUsuario(id);
        if (clienteDTO != null) {
            return ResponseEntity.ok(clienteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
