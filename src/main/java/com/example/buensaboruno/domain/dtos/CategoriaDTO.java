package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.shortDTO.ArticuloShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.CategoriaShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.domain.entities.Sucursal;
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
public class CategoriaDTO extends BaseDTO{

    private String denominacion;
    private Set<SucursalShortDTO> sucursales = new HashSet<>();
    private Set<Articulo> articulos = new HashSet<>();
    private Set<CategoriaDTO> subCategorias = new HashSet<>();
}
