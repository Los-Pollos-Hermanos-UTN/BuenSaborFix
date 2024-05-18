package com.example.buensaboruno.domain.responses;

import com.example.buensaboruno.domain.dtos.ProvinciaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProvinciaResponse {
    private List<ProvinciaDTO> provincias;
}