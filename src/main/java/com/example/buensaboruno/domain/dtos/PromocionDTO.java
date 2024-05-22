package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.entities.ImagenPromocion;
import com.example.buensaboruno.domain.entities.PromocionDetalle;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.domain.enums.TipoPromocion;
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
public class PromocionDTO extends BaseDTO {
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    private Set<PromocionDetalle> promocionDetalles = new HashSet<>();
    private Set<ImagenPromocion> imagenes = new HashSet<>();
    private Set<Sucursal> sucursales = new HashSet<>();
}
