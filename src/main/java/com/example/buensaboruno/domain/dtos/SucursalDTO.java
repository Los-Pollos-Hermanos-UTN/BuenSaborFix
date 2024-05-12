package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.entities.*;
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
public class SucursalDTO extends BaseDTO{

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean casaMatriz;
    private Domicilio domicilio;
    private Set<Promocion> promociones = new HashSet<>();
    private Set<Categoria> categorias = new HashSet<>();
    private Set<Empleado> empleados = new HashSet<>();
    private Empresa empresa;
}
