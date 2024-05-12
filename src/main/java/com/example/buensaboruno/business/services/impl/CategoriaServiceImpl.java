package com.example.buensaboruno.business.services.impl;


import com.example.buensaboruno.business.services.CategoriaService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.Articulo;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.repositories.BaseRepository;
import com.example.buensaboruno.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(BaseRepository<Categoria, Long> baseRepository, CategoriaRepository categoriaRepository) {
        super(baseRepository);
        this.categoriaRepository = categoriaRepository;
    }
}
