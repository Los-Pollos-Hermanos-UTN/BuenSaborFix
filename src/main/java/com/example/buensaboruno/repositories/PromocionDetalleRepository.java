package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.PromocionDetalle;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionDetalleRepository extends BaseRepository<PromocionDetalle,Long> {
}
