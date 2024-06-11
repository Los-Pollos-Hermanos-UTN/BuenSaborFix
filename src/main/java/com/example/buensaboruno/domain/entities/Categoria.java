package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.entities.base.Base;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

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
public class Categoria extends Base {
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    @OneToMany(mappedBy = "categoria")
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "padre_id")
    private Categoria padre;

    @OneToMany(mappedBy = "padre")
    @Builder.Default
    private Set<Categoria> subCategorias = new HashSet<>();
}
