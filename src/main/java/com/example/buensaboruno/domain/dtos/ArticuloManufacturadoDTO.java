package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.entities.ArticuloManufacturadoDetalle;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ArticuloManufacturadoDTO extends ArticuloDTO{

    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    private Set<ArticuloManufacturadoDetalleDTO> articuloManufacturadoDetalles = new HashSet<>();
}
