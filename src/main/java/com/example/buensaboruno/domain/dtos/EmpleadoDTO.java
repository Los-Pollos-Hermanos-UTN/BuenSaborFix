package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.PedidoShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.ImagenEmpleado;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import com.example.buensaboruno.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoDTO extends BaseDTO {

    private Rol tipoEmpleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private UsuarioEmpleado usuarioEmpleado;
    private ImagenEmpleadoDTO imagenes;
    private Set<PedidoShortDTO> pedidos= new HashSet<>();
    private SucursalShortDTO sucursal;
}
