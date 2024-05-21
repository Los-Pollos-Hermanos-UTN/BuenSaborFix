package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.shortDTO.ArticuloShortDTO;
import com.example.buensaboruno.domain.entities.Articulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedidoDTO extends BaseDTO{

    private Integer cantidad;
    private Double subTotal;
    private ArticuloDTO articulo;
}
