package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.PromocionFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.PromocionMapper;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.PromocionService;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.PromocionServiceImpl;
import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.entities.*;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.PromocionRepository;
import com.example.buensaboruno.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PromocionFacadeImpl extends BaseFacadeImpl<Promocion, PromocionDTO, Long> implements PromocionFacade {

    @Autowired
    private PromocionRepository promocionRepository;

    @Autowired
    private PromocionServiceImpl promocionServiceImpl;

    @Autowired
    private PromocionMapper promocionMapper;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public PromocionFacadeImpl(BaseService<Promocion, Long> baseService, BaseMapper<Promocion, PromocionDTO> baseMapper) {
        super(baseService, baseMapper);
    }

    public PromocionDTO createPromocion(PromocionDTO promocionDTO) {
        // Map DTO to Entity
        Promocion promocion = promocionMapper.toEntity(promocionDTO);

        // Save promocion
        Promocion savedPromocion = promocionRepository.save(promocion);

        // Return DTO
        return promocionMapper.toDTO(savedPromocion);
    }

    public PromocionDTO editPromocion(Long id, PromocionDTO promocionDTO) {
        // Map DTO to Entity
        Promocion promocion = promocionMapper.toEntity(promocionDTO);
        promocion.setId(id);

        // Update promocion
        Promocion updatedPromocion = promocionRepository.save(promocion);

        // Return DTO
        return promocionMapper.toDTO(updatedPromocion);
    }
}