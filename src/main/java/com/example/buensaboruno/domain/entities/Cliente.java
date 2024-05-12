package com.example.buensaboruno.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//@Audited
public class Cliente extends Base{

    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String email;
    protected LocalDate fechaNac;

    @OneToOne
    protected UsuarioCliente usuario;

    @OneToOne
    @NotAudited
    protected ImagenCliente imagenCliente;

    @ManyToMany
    //SE AGREGA EL JOIN TABLE PARA QUE JPA CREE LA TABLA INTERMEDIA EN UNA RELACION MANY TO MANY
    @JoinTable(name = "cliente_domicilio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACION DE LA LISTA
    @Builder.Default
    @JsonManagedReference
    protected Set<Domicilio> domicilios = new HashSet<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACION DE LA LISTA
    @Builder.Default
    @JsonManagedReference
    private Set<Pedido> pedidos = new HashSet<>();
}
