package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.CategoriaFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.mapper.CategoriaMapper;
import com.example.buensaboruno.business.mapper.SucursalMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.CategoriaServiceImpl;
import com.example.buensaboruno.domain.dtos.CategoriaDTO;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.repositories.CategoriaRepository;
import com.example.buensaboruno.repositories.SucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoriaFacadeImpl extends BaseFacadeImpl<Categoria, CategoriaDTO, Long> implements CategoriaFacade {
    public CategoriaFacadeImpl(BaseService<Categoria, Long> baseService, BaseMapper<Categoria, CategoriaDTO> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaServiceImpl categoriaServiceImpl;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private SucursalRepository sucursalRepository;

    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        // Map DTO to Entity
        Categoria categoria = categoriaMapper.toEntityWithContextMapping(categoriaDTO, categoriaRepository);

        // Ensure sucursales are loaded from DB
        Set<Sucursal> sucursales = categoria.getSucursales().stream()
                .map(sucursal -> sucursalRepository.findById(sucursal.getId())
                        .orElseThrow(() -> new RuntimeException("Sucursal not found: " + sucursal.getId())))
                .collect(Collectors.toSet());

        // Assign categoria to sucursales and sucursales to categoria
        for (Sucursal sucursal : sucursales) {
            sucursal.getCategorias().add(categoria);
        }
        categoria.setSucursales(sucursales);

        // Save categoria
        Categoria savedCategoria = categoriaRepository.save(categoria);

        // Save sucursales to update the relationship in the database
        sucursalRepository.saveAll(sucursales);

        // Return DTO
        return categoriaMapper.toDTO(savedCategoria);
    }


    public CategoriaDTO editCategoria(Long id, CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaMapper.toEntityWithContextMapping(categoriaDTO, categoriaRepository);
        try {
            categoria = categoriaServiceImpl.editCategoria(categoria, id);
            return categoriaMapper.toDTO(categoria);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Set<CategoriaDTO> getAll() {
        List<Categoria> categorias = categoriaRepository.findAllNotDeleted();
        // Filtrar solo las categorías que no tienen un padre (categorías principales)
        Set<Categoria> categoriasPadre = categorias.stream()
                .filter(categoria -> categoria.getPadre() == null)
                .collect(Collectors.toSet());
        return categoriaMapper.toDTOsList(categoriasPadre);
    }

    public Set<CategoriaDTO> listCategoriasByEmpresaId(Long id) {
        Set<Categoria> categorias = categoriaRepository.findCategoriasByEmpresaId(id);
        // Filtrar solo las categorías que no tienen un padre (categorías principales)
        Set<Categoria> categoriasPadre = categorias.stream()
                .filter(categoria -> categoria.getPadre() == null)
                .collect(Collectors.toSet());
        return categoriaMapper.toDTOsList(categoriasPadre);
    }
}

