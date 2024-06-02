package com.example.buensaboruno.domain.dtos;

import com.example.buensaboruno.domain.dtos.base.BaseDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.ClienteShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.EmpleadoShortDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.domain.entities.DetallePedido;
import com.example.buensaboruno.domain.enums.Estado;
import com.example.buensaboruno.domain.enums.FormaPago;
import com.example.buensaboruno.domain.enums.TipoEnvio;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoDTO extends BaseDTO {
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    private DomicilioDTO domicilio;

    private SucursalShortDTO sucursal;

    private FacturaDTO factura;

    private ClienteShortDTO cliente;

    private Set<DetallePedidoDTO> detallePedidos = new HashSet<>();

    private EmpleadoShortDTO empleado;
}
