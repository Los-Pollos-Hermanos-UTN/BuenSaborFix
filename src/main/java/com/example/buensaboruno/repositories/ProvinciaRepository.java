package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.domain.entities.Provincia;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvinciaRepository extends BaseRepository<Provincia,Long> {
    Optional<Provincia> findByNombreAndPais(String nombre, Pais argentina);
}
