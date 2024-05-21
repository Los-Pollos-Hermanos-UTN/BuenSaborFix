package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.domain.entities.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria,Long>{
    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.sucursales WHERE c.id = :id")
    Categoria findWithSucursalesById(@Param("id") Long id);

    @Query("SELECT c FROM Categoria c JOIN c.sucursales s WHERE s.empresa.id = :empresaId")
    List<Categoria> findByEmpresaId(@Param("empresaId") Long empresaId);
}


