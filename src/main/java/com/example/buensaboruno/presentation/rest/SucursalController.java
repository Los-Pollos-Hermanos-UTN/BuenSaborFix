package com.example.buensaboruno.presentation.rest;

import com.example.buensaboruno.business.facade.impl.SucursalFacadeImpl;
import com.example.buensaboruno.domain.dtos.SucursalDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.EmpresaShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.presentation.base.BaseControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/sucursal")
public class SucursalController extends BaseControllerImpl<Sucursal, SucursalDTO, Long, SucursalFacadeImpl> {
    public SucursalController(SucursalFacadeImpl facade){
        super(facade);
    }

    @GetMapping("/{id}/short")
    public ResponseEntity<SucursalShortDTO> getShort(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facade.getShort(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/short")
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

    @PutMapping("/{id}/short")
    public ResponseEntity<SucursalShortDTO> updateShort(@PathVariable Long id, @RequestBody SucursalShortDTO sucursalShortDTO) {
        try {
            return ResponseEntity.ok(facade.updateShort(id, sucursalShortDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
