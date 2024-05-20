package com.example.buensaboruno.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@Entity
//@Audited
public class ArticuloManufacturadoDetalle extends Base{
    private Double cantidad;

    @ManyToOne
    private ArticuloInsumo articuloInsumo;
}
