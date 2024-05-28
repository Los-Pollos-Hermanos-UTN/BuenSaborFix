package com.example.buensaboruno.domain.dtos.base;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ImagenBaseDTO {
    private UUID id;
    private String name;
    private String url;

    public ImagenBaseDTO(String url) {
        this.url = url;
    }
}
