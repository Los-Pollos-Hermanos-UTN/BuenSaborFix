package com.example.buensaboruno.domain.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
//@Audited
public class UsuarioCliente extends Base{
    private String auth0Id;
    private String userName;


}
