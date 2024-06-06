package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.entities.base.Base;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.NotAudited;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Empresa extends Base {

    private String nombre;
    private String razonSocial;
    private Long cuil;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empresa")
    @Builder.Default
    @JsonManagedReference
    private Set<Sucursal> sucursales = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @NotAudited
    protected Set<ImagenEmpresa> imagenes;
}
