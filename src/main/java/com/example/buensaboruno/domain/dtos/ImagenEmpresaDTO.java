package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.ImagenBaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ImagenEmpresaDTO extends ImagenBaseDTO {

    public ImagenEmpresaDTO(String url){
        super(url);
    }
}
