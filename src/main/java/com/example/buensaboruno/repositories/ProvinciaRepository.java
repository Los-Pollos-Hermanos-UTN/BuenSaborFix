package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Provincia;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends BaseRepository<Provincia,Long> {
}
