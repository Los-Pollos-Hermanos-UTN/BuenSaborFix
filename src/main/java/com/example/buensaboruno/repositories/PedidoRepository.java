package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.dtos.OrdersByCategoryDTO;
import com.example.buensaboruno.domain.dtos.TopSellingProductDTO;
import com.example.buensaboruno.domain.entities.Pedido;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {

    @Query("SELECT p FROM Pedido p WHERE p.sucursal.empresa.id = :empresaId")
    List<Pedido> findByEmpresaId(@Param("empresaId") Long empresaId);

    @Query("SELECT new com.example.buensaboruno.domain.dtos.TopSellingProductDTO(a.denominacion, SUM(dp.cantidad)) " +
            "FROM Pedido p JOIN p.detallePedidos dp JOIN dp.articulo a " +
            "GROUP BY a.denominacion ORDER BY SUM(dp.cantidad) DESC")
    List<TopSellingProductDTO> findTopSellingProducts(Pageable pageable);

    @Query("SELECT new com.example.buensaboruno.domain.dtos.OrdersByCategoryDTO(c.denominacion, COUNT(p)) " +
            "FROM Pedido p JOIN p.detallePedidos dp JOIN dp.articulo a JOIN a.categoria c " +
            "GROUP BY c.denominacion ORDER BY COUNT(p) DESC")
    List<OrdersByCategoryDTO> findOrdersByCategory();
}
