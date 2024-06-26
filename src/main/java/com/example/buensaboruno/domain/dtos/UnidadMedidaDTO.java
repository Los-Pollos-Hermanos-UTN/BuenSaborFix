package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UnidadMedidaDTO extends BaseDTO {

    private String denominacion;
}
