package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ArticuloManufacturadoMapper;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.ArticuloManufacturadoServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.domain.entities.Categoria;
import com.example.buensaboruno.repositories.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoFacadeImpl extends BaseFacadeImpl<ArticuloManufacturado, ArticuloManufacturadoDTO, Long> implements ArticuloManufacturadoFacade {
    public ArticuloManufacturadoFacadeImpl(BaseService<ArticuloManufacturado, Long> baseService, BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDTO> baseMapper){
        super(baseService, baseMapper);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ArticuloManufacturadoMapper articuloManufacturadoMapper;

    @Autowired
    private ArticuloManufacturadoServiceImpl articuloManufacturadoService;


    public ArticuloManufacturadoDTO createArticuloManufacturado(ArticuloManufacturadoDTO articuloManufacturadoDTO) {
        ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();

        articuloManufacturado.setDenominacion(articuloManufacturadoDTO.getDenominacion());
        articuloManufacturado.setPrecioVenta(articuloManufacturadoDTO.getPrecioVenta());

        if (articuloManufacturadoDTO.getCategoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(articuloManufacturadoDTO.getCategoriaId())
                    .orElseThrow(() -> new EntityNotFoundException("Categoria not found"));
            articuloManufacturado.setCategoria(categoria);
        }

        articuloManufacturado = articuloManufacturadoService.createArticuloManufacturado(articuloManufacturado);
        return articuloManufacturadoMapper.toDTO(articuloManufacturado);
    }
}
