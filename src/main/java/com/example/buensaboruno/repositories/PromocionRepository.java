package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Promocion;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromocionRepository extends BaseRepository<Promocion,Long> {
    @Query("SELECT p FROM Promocion p LEFT JOIN FETCH p.sucursales WHERE p.id = :id")
    Promocion findAllWithSucursales(@Param("id") Long id);

    @EntityGraph(attributePaths = {"promocionDetalles", "sucursales"})
    Optional<Promocion> findById(Long id);

}
