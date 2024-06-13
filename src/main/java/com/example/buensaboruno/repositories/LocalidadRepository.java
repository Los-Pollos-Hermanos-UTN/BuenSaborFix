package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Localidad;
import com.example.buensaboruno.domain.entities.Pais;
import com.example.buensaboruno.domain.entities.Provincia;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad,Long> {

    Optional<Localidad> findByNombreAndProvincia(String nombre, Provincia provincia);
}
