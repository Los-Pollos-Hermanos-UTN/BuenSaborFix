package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalleDTO extends BaseDTO{

    private Integer cantidad;
    private ArticuloInsumo articuloInsumo;
}
