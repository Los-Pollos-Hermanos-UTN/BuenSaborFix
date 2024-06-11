package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {

    @Query("SELECT am FROM ArticuloManufacturado am WHERE am.eliminado = false AND am.categoria IN (SELECT c FROM Categoria c JOIN c.sucursales s WHERE s.empresa.id = :empresaId AND c.eliminado = false) AND am.eliminado = false")
    List<ArticuloManufacturado> findByEmpresaId(@Param("empresaId") Long empresaId);

    @Query("SELECT a FROM ArticuloManufacturado a WHERE a.categoria.id = :categoriaId AND a.eliminado = false")
    List<ArticuloManufacturado> findByCategoriaIdAndNotEliminado(@Param("categoriaId") Long categoriaId);

    @Query("SELECT am FROM ArticuloManufacturado am JOIN am.articuloManufacturadoDetalles amd JOIN amd.articuloInsumo ai " +
            "WHERE am.categoria.id = :categoriaId AND am.eliminado = false AND ai.eliminado = false")
    List<ArticuloManufacturado> findByCategoriaIdAndNotEliminadoAndNotArticuloInsumoEliminado(@Param("categoriaId") Long categoriaId);
}
