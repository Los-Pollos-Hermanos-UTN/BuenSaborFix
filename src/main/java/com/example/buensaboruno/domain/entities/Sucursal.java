package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.entities.base.Base;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.NotAudited;

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
public class Sucursal extends Base {

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean casaMatriz;

    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable(name = "promocion_sucursal",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "sucursal_id"))
    @Builder.Default
    @JsonManagedReference
    private Set<Promocion> promociones = new HashSet<>();

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable(name = "sucursal_categoria",
            joinColumns = @JoinColumn(name = "sucursal_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @Builder.Default
    @JsonManagedReference
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @Builder.Default
    @JsonManagedReference
    private Set<Empleado> empleados = new HashSet<>();

    @ManyToOne
    @JsonBackReference
    private Empresa empresa;

    @OneToOne (cascade=CascadeType.ALL)
    @NotAudited
    protected ImagenSucursal imagenSucursal;
}
