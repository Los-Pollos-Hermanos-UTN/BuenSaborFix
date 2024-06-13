package com.example.buensaboruno.domain.dtos.shortDTO;

import com.example.buensaboruno.domain.dtos.ImagenEmpleadoDTO;
import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpresaShortDTO extends BaseDTO {

    private String nombre;
    private String razonSocial;
    private Long cuil;
    private Set<ImagenEmpleadoDTO> imagenes;
}
