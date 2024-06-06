package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.PromocionFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.PromocionMapper;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.ImagenPromocionServiceImpl;
import com.example.buensaboruno.domain.dtos.ImagenPromocionDTO;
import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.*;
import com.example.buensaboruno.repositories.PromocionRepository;
import com.example.buensaboruno.repositories.SucursalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PromocionFacadeImpl extends BaseFacadeImpl<Promocion, PromocionDTO, Long> implements PromocionFacade {

    @Autowired
    private PromocionRepository promocionRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private PromocionMapper promocionMapper;

    private final ObjectMapper objectMapper;

    @Autowired
    private ImagenPromocionServiceImpl imagenPromocionServiceImpl;


    public PromocionFacadeImpl(BaseService<Promocion, Long> baseService, BaseMapper<Promocion, PromocionDTO> baseMapper, ObjectMapper objectMapper) {
        super(baseService, baseMapper);
        this.objectMapper = objectMapper;
    }

    public PromocionDTO uploadImages(PromocionDTO promocionDTO, MultipartFile[] files){
        if (files != null && files.length > 0) {

            // Subir las imágenes y obtener las URLs
            List<String> imageUrls = imagenPromocionServiceImpl.saveImages(files);

            // Crear un conjunto de imágenes a partir de las URLs
            Set<ImagenPromocionDTO> nuevasImagenes = imageUrls.stream()
                    .map(url -> new ImagenPromocionDTO(url))
                    .collect(Collectors.toSet());

            // Verificar si promocionDTO ya tiene imágenes
            if (promocionDTO.getImagenes() != null && !promocionDTO.getImagenes().isEmpty()) {
                // Mantener las imágenes existentes y agregar las nuevas
                promocionDTO.getImagenes().addAll(nuevasImagenes);
            } else {
                promocionDTO.setImagenes(nuevasImagenes);
            }
        }
        return promocionDTO;
    }

    @Transactional
    public PromocionDTO createPromocion(PromocionDTO promocionDTO) {

        Set<Sucursal> sucursales = new HashSet<>();
        for (SucursalShortDTO sucursalShortDTO : promocionDTO.getSucursales()) {
            Optional<Sucursal> sucursalOptional = sucursalRepository.findById(sucursalShortDTO.getId());
            sucursalOptional.ifPresent(sucursales::add);
        }

        Promocion promocion = promocionMapper.toEntity(promocionDTO);

        if(!sucursales.isEmpty()){
            promocion.setSucursales(sucursales);
        }

        // Establecer la relación de Promocion en cada PromocionDetalle
        for (PromocionDetalle detalle : promocion.getPromocionDetalles()) {
            detalle.setPromocion(promocion);
        }

        Promocion savedPromocion = promocionRepository.save(promocion);

        for(Sucursal sucursal : sucursales){
            sucursal.getPromociones().add(savedPromocion);
            sucursalRepository.save(sucursal);
        }

        return promocionMapper.toDTO(savedPromocion);
    }

    @Transactional
    public PromocionDTO editPromocion(Long id, PromocionDTO promocionDTO) {
        Promocion promocion = promocionMapper.toEntity(promocionDTO);

        Set<Sucursal> currentSucursales = promocion.getSucursales();

        for(Sucursal sucursal: currentSucursales){
            sucursal.getPromociones().remove(promocion);
            sucursalRepository.save(sucursal);
        }

        Set<Sucursal> newSucursales = new HashSet<>();

        for(SucursalShortDTO sucursal: promocionDTO.getSucursales()){
            Optional<Sucursal> sucursalOptional = sucursalRepository.findById(sucursal.getId());
            sucursalOptional.ifPresent(newSucursales::add);
        }

        // Establecer la relación de Promocion en cada PromocionDetalle
        for (PromocionDetalle detalle : promocion.getPromocionDetalles()) {
            detalle.setPromocion(promocion);
        }

        Promocion updatedPromocion = promocionRepository.save(promocion);

        for(Sucursal sucursal : newSucursales){
            sucursal.getPromociones().add(updatedPromocion);
            sucursalRepository.save(sucursal);
        }

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