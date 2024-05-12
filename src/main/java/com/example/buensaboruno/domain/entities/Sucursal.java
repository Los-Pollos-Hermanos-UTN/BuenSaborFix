package com.example.buensaboruno.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
//@Audited
public class Sucursal extends  Base{

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean casaMatriz;

    @OneToOne
    private Domicilio domicilio;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable(name = "sucursal_promocion",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "sucursal_id"))
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACION DE LA LISTA
    @Builder.Default
    @JsonManagedReference
    private Set<Promocion> promociones = new HashSet<>();

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @ToString.Exclude
    //SE AGREGA EL JOIN TABLE PARA QUE JPA CREE LA TABLA INTERMEDIA
    // EN UNA RELACION MANY TO MANY
    @JoinTable(name = "sucursal_categoria",
            joinColumns = @JoinColumn(name = "sucursal_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACION DE LA LISTA
    @Builder.Default
    @JsonManagedReference
    private Set<Categoria> categorias = new HashSet<>();




    @OneToMany(mappedBy = "sucursal",cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @Builder.Default
    @JsonManagedReference
    private Set<Empleado> empleados = new HashSet<>();

    @ManyToOne
    @JsonBackReference
    private Empresa empresa;
}
