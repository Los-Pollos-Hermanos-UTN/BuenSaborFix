package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.entities.base.Base;
import com.example.buensaboruno.domain.enums.Rol;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Audited
public class Empleado extends Base {
    private Rol tipoEmpleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    private UsuarioEmpleado usuarioEmpleado;

    @OneToMany(cascade = CascadeType.ALL)
    @NotAudited
    private Set<ImagenEmpleado> imagenes;


    @OneToMany(mappedBy = "empleado", cascade = CascadeType.REFRESH, orphanRemoval = true)
    @ToString.Exclude
    @Builder.Default
    @JsonManagedReference
    private Set<Pedido> pedidos = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "sucursal_id")
    @JsonBackReference
    private Sucursal sucursal;
}
