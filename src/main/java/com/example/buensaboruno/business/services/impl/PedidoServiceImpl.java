package com.example.buensaboruno.business.services.impl;


import com.example.buensaboruno.business.services.PedidoService;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends  BaseServiceImpl<Pedido, Long> implements PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }
}
