package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida,Long> {

    @Query("SELECT um FROM UnidadMedida um WHERE um IN (SELECT a.unidadMedida FROM Articulo a WHERE a.categoria IN (SELECT c FROM Categoria c JOIN c.sucursales s WHERE s.empresa.id = :empresaId))")
    List<UnidadMedida> findByEmpresaId(@Param("empresaId") Long empresaId);

}
