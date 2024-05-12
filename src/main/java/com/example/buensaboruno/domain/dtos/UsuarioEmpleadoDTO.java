package com.example.buensaboruno.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioEmpleadoDTO extends BaseDTO{

    private String auth0Id;
    private String userName;
}
