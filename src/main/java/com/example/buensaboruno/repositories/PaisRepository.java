package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends BaseRepository<Pais,Long> {
    Optional<Pais> findByNombre(String nombre);
}
