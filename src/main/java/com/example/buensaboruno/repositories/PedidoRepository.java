package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {

    @Query("SELECT p FROM Pedido p WHERE p.sucursal.empresa.id = :empresaId")
    List<Pedido> findByEmpresaId(@Param("empresaId") Long empresaId);

}
