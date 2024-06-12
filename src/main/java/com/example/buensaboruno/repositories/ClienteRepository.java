package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.UsuarioCliente;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {
    Cliente findByUsuario(UsuarioCliente usuario);

    Optional<Cliente> findByEmail(String email);
}
