package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.UsuarioEmpleadoService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.UsuarioEmpleado;
import com.example.buensaboruno.repositories.base.BaseRepository;
import com.example.buensaboruno.repositories.UsuarioEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEmpleadoServiceImpl extends BaseServiceImpl<UsuarioEmpleado, Long> implements UsuarioEmpleadoService {
    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    public UsuarioEmpleadoServiceImpl(BaseRepository<UsuarioEmpleado, Long> baseRepository, UsuarioEmpleadoRepository usuarioEmpleadoRepository) {
        super(baseRepository);
        this.usuarioEmpleadoRepository=usuarioEmpleadoRepository;
    }
}
