package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado,Long> {
    Optional<Empleado> findByEmail(String email);

}
