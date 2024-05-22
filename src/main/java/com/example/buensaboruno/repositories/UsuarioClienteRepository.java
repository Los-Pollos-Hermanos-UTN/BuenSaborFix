package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioClienteRepository extends BaseRepository<UsuarioCliente,Long> {
}
