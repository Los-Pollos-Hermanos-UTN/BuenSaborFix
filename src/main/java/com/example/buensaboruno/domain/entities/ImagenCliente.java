package com.example.buensaboruno.domain.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class ImagenCliente extends Base{
    private String url;
}
