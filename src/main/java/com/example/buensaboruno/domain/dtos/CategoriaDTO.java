package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaDTO extends BaseDTO {
    private String denominacion;
    private Set<SucursalShortDTO> sucursales = new HashSet<>();
    private Set<ArticuloDTO> articulos = new HashSet<>();
    private Set<CategoriaDTO> subCategorias = new HashSet<>();
    private Long padreId; // Agregado para referenciar al padre
}
