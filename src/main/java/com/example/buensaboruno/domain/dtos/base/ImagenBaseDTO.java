package com.example.buensaboruno.domain.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImagenBaseDTO {
    private UUID id;
    private String name;
    private String url;
}
