package com.example.buensaboruno.repositories;

import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends BaseRepository<Empresa,Long> {
    @Query("SELECT e FROM Empresa e LEFT JOIN FETCH e.sucursales WHERE e.id = :id")
    Empresa findWithSucursalesById(@Param("id") Long id);

    @Query("SELECT DISTINCT e FROM Empleado emp " +
            "JOIN emp.sucursal s " +
            "JOIN s.empresa e " +
            "WHERE emp.id = :empleadoId AND e.eliminado != true")
    List<Empresa> findEmpresasByEmpleadoId(@Param("empleadoId") Long empleadoId);
}
