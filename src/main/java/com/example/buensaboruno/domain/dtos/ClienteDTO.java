package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.PedidoShortDTO;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.domain.entities.ImagenCliente;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
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
public class ClienteDTO extends BaseDTO {

    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String email;
    protected String contrasenia;
    protected LocalDate fechaNac;
    protected UsuarioCliente usuario;
    protected ImagenClienteDTO imagenCliente;
    protected Set<DomicilioDTO> domicilios = new HashSet<>();
    private Set<PedidoShortDTO> pedidos = new HashSet<>();
}
