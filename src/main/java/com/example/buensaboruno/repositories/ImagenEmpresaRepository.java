package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ImagenEmpresa;
import com.example.buensaboruno.repositories.base.ImagenBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImagenEmpresaRepository extends ImagenBaseRepository<ImagenEmpresa, UUID> {
}
