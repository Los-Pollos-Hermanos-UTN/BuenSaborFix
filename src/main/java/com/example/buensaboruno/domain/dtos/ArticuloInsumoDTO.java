package com.example.buensaboruno.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloInsumoDTO extends ArticuloDTO{

    private Double precioCompra;
    private Double stockActual;
    private Double stockMaximo;
    private Boolean esParaElaborar;
}
