package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEmpleadoRepository extends BaseRepository<UsuarioEmpleado,Long> {
}
