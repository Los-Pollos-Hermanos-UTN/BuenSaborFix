package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long> {
}
