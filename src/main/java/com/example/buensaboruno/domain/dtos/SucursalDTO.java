package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.CategoriaShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.EmpleadoShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.EmpresaShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.PromocionShortDTO;
import com.example.buensaboruno.domain.entities.ImagenSucursal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SucursalDTO extends BaseDTO {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean casaMatriz;
    private DomicilioDTO domicilio;
    private Set<PromocionShortDTO> promociones = new HashSet<>();
    private Set<CategoriaShortDTO> categorias = new HashSet<>();
    private Set<EmpleadoShortDTO> empleados = new HashSet<>();
    private EmpresaShortDTO empresa;
    protected ImagenSucursalDTO imagenSucursal;
}
