package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.entities.base.ImagenBase;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class ImagenArticulo extends ImagenBase {
}
