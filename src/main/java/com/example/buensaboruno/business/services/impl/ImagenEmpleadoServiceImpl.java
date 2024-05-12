package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.services.ImagenClienteService;
import com.example.buensaboruno.business.services.ImagenEmpleadoService;
import com.example.buensaboruno.domain.entities.ImagenCliente;
import com.example.buensaboruno.domain.entities.ImagenEmpleado;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.ImagenClienteRepository;
import com.example.buensaboruno.repositories.ImagenEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenEmpleadoServiceImpl extends BaseServiceImpl<ImagenEmpleado, Long> implements ImagenEmpleadoService {
    @Autowired
    private ImagenEmpleadoRepository imagenEmpleadoRepository;

    public ImagenEmpleadoServiceImpl(BaseRepository<ImagenEmpleado, Long> baseRepository, ImagenEmpleadoRepository imagenEmpleadoRepository) {
        super(baseRepository);
        this.imagenEmpleadoRepository=imagenEmpleadoRepository;
    }
}
