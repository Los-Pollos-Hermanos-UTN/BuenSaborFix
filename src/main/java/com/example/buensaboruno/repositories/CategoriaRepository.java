package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Articulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends BaseRepository<Articulo,Long>{
    @Query("SELECT c FROM Articulo c LEFT JOIN FETCH c.sucursales WHERE c.id = :id")
    Articulo findWithSucursalesById(@Param("id") Long id);
}


