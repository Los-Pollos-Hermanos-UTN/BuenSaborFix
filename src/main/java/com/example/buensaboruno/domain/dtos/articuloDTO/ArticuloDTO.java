package com.example.buensaboruno.domain.dtos.articuloDTO;

import com.example.buensaboruno.domain.dtos.BaseDTO;
import com.example.buensaboruno.domain.entities.ImagenArticulo;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloDTO extends BaseDTO {

    protected String denominacion;
    protected Double precioVenta;
    protected Set<ImagenArticulo> imagenes = new HashSet<>();
    protected UnidadMedida unidadMedida;
}
