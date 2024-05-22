package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.DetallePedido;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido,Long> {
}
