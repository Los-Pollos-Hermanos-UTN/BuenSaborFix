package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.entities.base.Base;
import com.example.buensaboruno.domain.enums.Estado;
import com.example.buensaboruno.domain.enums.FormaPago;
import com.example.buensaboruno.domain.enums.TipoEnvio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Audited
public class Pedido extends Base {

    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotAudited
    private Domicilio domicilio;

    @ManyToOne
    private Sucursal sucursal;

    @OneToOne(cascade = CascadeType.ALL)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private Set<DetallePedido> detallePedidos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    @JsonBackReference
    private Empleado empleado;
}
