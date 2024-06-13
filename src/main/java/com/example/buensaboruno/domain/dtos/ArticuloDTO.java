package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticuloDTO extends BaseDTO {
    protected String denominacion;
    protected Double precioVenta;
    protected Set<ImagenArticuloDTO> imagenes = new HashSet<>();
    protected UnidadMedida unidadMedida;
    private Long categoriaId; // Agregado para referenciar la categoría
}
