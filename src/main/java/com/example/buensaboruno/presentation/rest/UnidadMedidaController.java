package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.UnidadMedidaFacadeImpl;
import com.example.buensaboruno.domain.dtos.PedidoDTO;
import com.example.buensaboruno.domain.dtos.UnidadMedidaDTO;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/unidadMedida")
public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaDTO, Long, UnidadMedidaFacadeImpl> {
    public UnidadMedidaController(UnidadMedidaFacadeImpl facade){
        super(facade);
    }

    @Autowired
    private UnidadMedidaFacadeImpl unidadMedidaFacadeImpl;

    @GetMapping(value = "/listByEmpresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UnidadMedidaDTO>> listUnidadesMedidaByEmpresa(@PathVariable Long id) {
        List<UnidadMedidaDTO> unidadMedidaDTOS = unidadMedidaFacadeImpl.findUnidadesMedidaByEmpresaId(id);
        return new ResponseEntity<>(unidadMedidaDTOS, HttpStatus.OK);
    }
}
