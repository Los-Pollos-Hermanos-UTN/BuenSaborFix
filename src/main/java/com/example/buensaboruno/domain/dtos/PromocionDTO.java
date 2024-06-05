package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import com.example.buensaboruno.domain.entities.PromocionDetalle;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.domain.enums.TipoPromocion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromocionDTO extends BaseDTO {
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    private Set<PromocionDetalleDTO> promocionDetalles = new HashSet<>();
    private Set<ImagenPromocionDTO> imagenes = new HashSet<>();
    private Set<SucursalShortDTO> sucursales = new HashSet<>();
}
