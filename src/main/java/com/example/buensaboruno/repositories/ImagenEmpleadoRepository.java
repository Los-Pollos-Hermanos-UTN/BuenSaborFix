package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ImagenEmpleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenEmpleadoRepository extends BaseRepository<ImagenEmpleado, Long> {
}
