package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ArticuloManufacturadoDetalleDTO extends BaseDTO {

    private Double cantidad;
    private ArticuloInsumoDTO articuloInsumo;
}
