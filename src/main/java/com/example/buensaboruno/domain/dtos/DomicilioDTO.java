package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.entities.Localidad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DomicilioDTO extends BaseDTO {

    private String calle;
    private Integer numero;
    private Integer cp;
    private Integer piso;
    private Integer nroDepto;
    private Localidad localidad;
}
