package com.example.buensaboruno.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
//@Audited
public class ArticuloInsumo extends Articulo{
    private Double precioCompra;
    private Double stockActual;
    private Double stockMaximo;
    private Boolean esParaElaborar;

}
