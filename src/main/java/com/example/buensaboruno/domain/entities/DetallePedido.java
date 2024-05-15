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
public class DetallePedido extends Base{
    private Integer cantidad;
    private Double subTotal;

    @ManyToOne
    private Articulo articulo;

}
