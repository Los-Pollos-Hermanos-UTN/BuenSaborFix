package com.example.buensaboruno.domain.entities;


import com.example.buensaboruno.domain.entities.base.Base;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Provincia extends Base {
    private String nombre;

    @ManyToOne
    private Pais pais;

}
