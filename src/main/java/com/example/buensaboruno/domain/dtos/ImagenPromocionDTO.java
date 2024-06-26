package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.ImagenBaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ImagenPromocionDTO extends ImagenBaseDTO {
    public ImagenPromocionDTO(String url) {
        super(url);
    }
}
