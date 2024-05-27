package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ArticuloInsumoDTO.class, name = "insumo"),
        @JsonSubTypes.Type(value = ArticuloManufacturadoDTO.class, name = "manufacturado")
})
public class ArticuloDTO extends BaseDTO {
    protected String denominacion;
    protected Double precioVenta;
    protected Set<ImagenArticuloDTO> imagenes = new HashSet<>();
    protected UnidadMedida unidadMedida;
    private Long categoriaId; // Agregado para referenciar la categoría
}
