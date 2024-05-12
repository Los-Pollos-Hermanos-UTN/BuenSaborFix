package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.DetallePedidoService;
import com.example.buensaboruno.domain.entities.DetallePedido;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoRepository detallePedidoRepository) {
        super(baseRepository);
        this.detallePedidoRepository = detallePedidoRepository;
    }
}
