package com.example.buensaboruno.domain.dtos.shortDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedidoShortDTO {
    private Integer cantidad;
    private Double subTotal;
}
