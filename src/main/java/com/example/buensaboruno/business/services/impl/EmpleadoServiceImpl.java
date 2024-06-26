package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.EmpleadoService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.repositories.base.BaseRepository;
import com.example.buensaboruno.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Long> implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(BaseRepository<Empleado, Long> baseRepository, EmpleadoRepository empleadoRepository) {
        super(baseRepository);
        this.empleadoRepository=empleadoRepository;
    }

    public Empleado createEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public Empleado editEmpleado(Empleado empleado, Long id) throws Exception{
        return update(id, empleado);
    }
}
