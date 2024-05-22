package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {

    @Query("SELECT am FROM ArticuloManufacturado am WHERE am.categoria IN (SELECT c FROM Categoria c JOIN c.sucursales s WHERE s.empresa.id = :empresaId)")
    List<ArticuloManufacturado> findByEmpresaId(@Param("empresaId") Long empresaId);

}
