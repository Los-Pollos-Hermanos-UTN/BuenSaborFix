package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long> {

    @Query("SELECT ai FROM ArticuloInsumo ai WHERE ai.categoria IN (SELECT c FROM Categoria c JOIN c.sucursales s WHERE s.empresa.id = :empresaId)")
    List<ArticuloInsumo> findByEmpresaId(@Param("empresaId") Long empresaId);

}
