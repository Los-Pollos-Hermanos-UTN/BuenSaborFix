package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.PromocionFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.PromocionMapper;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.PromocionService;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.PromocionServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.entities.*;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.PromocionRepository;
import com.example.buensaboruno.repositories.SucursalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PromocionFacadeImpl extends BaseFacadeImpl<Promocion, PromocionDTO, Long> implements PromocionFacade {

    @Autowired
    private PromocionRepository promocionRepository;


    @Autowired
    private PromocionMapper promocionMapper;

    private final ObjectMapper objectMapper;


    public PromocionFacadeImpl(BaseService<Promocion, Long> baseService, BaseMapper<Promocion, PromocionDTO> baseMapper, ObjectMapper objectMapper) {
        super(baseService, baseMapper);
        this.objectMapper = objectMapper;
    }

    public PromocionDTO createPromocion(PromocionDTO promocionDTO) {
        Promocion promocion = promocionMapper.toEntity(promocionDTO);

        // Establecer la relación de Promocion en cada PromocionDetalle
        for (PromocionDetalle detalle : promocion.getPromocionDetalles()) {
            detalle.setPromocion(promocion);
        }


        Promocion savedPromocion = promocionRepository.save(promocion);
        return promocionMapper.toDTO(savedPromocion);
    }

    public PromocionDTO editPromocion(Long id, PromocionDTO promocionDTO) {
        Promocion promocion = promocionMapper.toEntity(promocionDTO);
        promocion.setId(id);

        // Establecer la relación de Promocion en cada PromocionDetalle
        for (PromocionDetalle detalle : promocion.getPromocionDetalles()) {
            detalle.setPromocion(promocion);
        }


        Promocion updatedPromocion = promocionRepository.save(promocion);
        return promocionMapper.toDTO(updatedPromocion);
    }

    public PromocionDTO mapperJson(String promocionJson) {
        try {
            return objectMapper.readValue(promocionJson, PromocionDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to map JSON to PromocionDTO", e);
        }
    }

}