package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado,Long> {
}
