package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ArticuloInsumoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ArticuloInsumoMapper;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.ArticuloInsumoServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoFacadeImpl extends BaseFacadeImpl<ArticuloInsumo, ArticuloInsumoDTO, Long> implements ArticuloInsumoFacade {
    public ArticuloInsumoFacadeImpl(BaseService<ArticuloInsumo, Long> baseService, BaseMapper<ArticuloInsumo, ArticuloInsumoDTO> baseMapper){
        super(baseService, baseMapper);
    }

    @Autowired
    private ArticuloInsumoServiceImpl articuloInsumoService;

    @Autowired
    private ArticuloInsumoMapper articuloInsumoMapper;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoDTO createArticuloInsumo(ArticuloInsumoDTO articuloInsumoDTO) {
        ArticuloInsumo articuloInsumo = articuloInsumoMapper.toEntityWithContextMapping(articuloInsumoDTO, categoriaRepository);
        articuloInsumo = articuloInsumoService.createArticuloInsumo(articuloInsumo);
        return articuloInsumoMapper.toDTO(articuloInsumo);
    }

    public ArticuloInsumoDTO editArticuloInsumo(ArticuloInsumoDTO articuloInsumoDTO, Long id){
        ArticuloInsumo articuloInsumo = articuloInsumoMapper.toEntityWithContextMapping(articuloInsumoDTO, categoriaRepository);
        try{
            articuloInsumo = articuloInsumoService.editArticuloInsumo(articuloInsumo, id);
            return articuloInsumoMapper.toDTO(articuloInsumo);
        }catch (Exception e){
            return null;
        }
    }

    public List<ArticuloInsumoDTO> findArticuloInsumosByEmpresaId(Long empresaId) {
        List<ArticuloInsumoDTO> articuloInsumoDTOS = articuloInsumoMapper.toDTOsList(articuloInsumoRepository.findByEmpresaId(empresaId));
        return articuloInsumoDTOS;
    }
}


