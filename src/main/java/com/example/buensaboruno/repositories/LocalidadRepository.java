package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Localidad;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad,Long> {
}
