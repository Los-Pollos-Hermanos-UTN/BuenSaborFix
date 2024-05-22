package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.entities.base.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@Entity
//@Audited
public class ArticuloManufacturadoDetalle extends Base {
    private Double cantidad;

    @ManyToOne
    private ArticuloInsumo articuloInsumo;
}
