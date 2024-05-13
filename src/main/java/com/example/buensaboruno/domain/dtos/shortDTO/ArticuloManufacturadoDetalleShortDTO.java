package com.example.buensaboruno.domain.dtos.shortDTO;

import com.example.buensaboruno.domain.dtos.ArticuloDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalleShortDTO extends ArticuloShortDTO {
    private Integer cantidad;
}
