package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends BaseRepository<Factura,Long> {
}
