package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.entities.base.Base;
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
@ToString
@SuperBuilder
@Audited
public class Cliente extends Base {

    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String email;
    protected LocalDate fechaNac;

    @OneToOne
    protected UsuarioCliente usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @NotAudited
    protected ImagenCliente imagenCliente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_domicilio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    @Builder.Default
    @JsonManagedReference
    @NotAudited
    protected Set<Domicilio> domicilios = new HashSet<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonManagedReference
    private Set<Pedido> pedidos = new HashSet<>();
}
