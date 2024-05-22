package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ImagenPromocion;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImagenPromocionRepository extends ImagenBaseRepository<ImagenPromocion, UUID> {
}
