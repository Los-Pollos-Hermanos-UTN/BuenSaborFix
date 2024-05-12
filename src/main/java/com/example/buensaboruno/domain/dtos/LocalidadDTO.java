package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.entities.Provincia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocalidadDTO extends BaseDTO{
    private String nombre;
    private Provincia provincia;
}
