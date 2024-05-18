package com.example.buensaboruno.domain.responses;

import com.example.buensaboruno.domain.dtos.LocalidadDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LocalidadResponse {
    private List<LocalidadDTO> localidades;
}
