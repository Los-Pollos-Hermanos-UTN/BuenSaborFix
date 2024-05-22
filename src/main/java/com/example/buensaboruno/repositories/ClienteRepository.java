package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {
}
