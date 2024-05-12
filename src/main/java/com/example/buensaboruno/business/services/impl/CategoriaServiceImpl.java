package com.example.buensaboruno.business.services.impl;


import com.example.buensaboruno.business.services.CategoriaService;
import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Articulo, Long> implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(BaseRepository<Articulo, Long> baseRepository, CategoriaRepository categoriaRepository) {
        super(baseRepository);
        this.categoriaRepository = categoriaRepository;
    }
}
