package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ArticuloInsumoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ArticuloInsumoMapper;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.ArticuloInsumoServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.repositories.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoFacadeImpl extends BaseFacadeImpl<ArticuloInsumo, ArticuloInsumoDTO, Long> implements ArticuloInsumoFacade {
    public ArticuloInsumoFacadeImpl(BaseService<ArticuloInsumo, Long> baseService, BaseMapper<ArticuloInsumo, ArticuloInsumoDTO> baseMapper){
        super(baseService, baseMapper);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ArticuloInsumoServiceImpl articuloInsumoService;

    @Autowired
    private ArticuloInsumoMapper articuloInsumoMapper;


    public ArticuloInsumoDTO createArticuloInsumo(ArticuloInsumoDTO articuloInsumoDTO) {
        ArticuloInsumo articuloInsumo = new ArticuloInsumo();
        // Asignar propiedades específicas de ArticuloInsumo

        articuloInsumo.setDenominacion(articuloInsumoDTO.getDenominacion());
        articuloInsumo.setPrecioVenta(articuloInsumoDTO.getPrecioVenta());

        if (articuloInsumoDTO.getCategoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(articuloInsumoDTO.getCategoriaId())
                    .orElseThrow(() -> new EntityNotFoundException("Categoria not found"));
            articuloInsumo.setCategoria(categoria);
        }

        articuloInsumo = articuloInsumoService.createArticuloInsumo(articuloInsumo);
        return articuloInsumoMapper.toDTO(articuloInsumo);
    }

}

