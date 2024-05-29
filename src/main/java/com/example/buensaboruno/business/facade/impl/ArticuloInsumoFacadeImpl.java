package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ArticuloInsumoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ArticuloInsumoMapper;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.ArticuloInsumoServiceImpl;
import com.example.buensaboruno.business.services.impl.ImagenArticuloServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import com.example.buensaboruno.repositories.CategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Autowired
    private ImagenArticuloServiceImpl imagenArticuloServiceImpl;

    public ArticuloInsumoDTO uploadImages(ArticuloInsumoDTO articuloInsumoDTO, MultipartFile[] files){
        if (files != null && files.length > 0) {

            // Subir las imágenes y obtener las URLs
            List<String> imageUrls = imagenArticuloServiceImpl.saveImages(files);

            // Crear un conjunto de imágenes a partir de las URLs
            Set<ImagenArticuloDTO> nuevasImagenes = imageUrls.stream()
                    .map(url -> new ImagenArticuloDTO(url))
                    .collect(Collectors.toSet());

            // Verificar si articuloInsumoDTO ya tiene imágenes
            if (articuloInsumoDTO.getImagenes() != null && !articuloInsumoDTO.getImagenes().isEmpty()) {
                // Mantener las imágenes existentes y agregar las nuevas
                articuloInsumoDTO.getImagenes().addAll(nuevasImagenes);
            } else {
                articuloInsumoDTO.setImagenes(nuevasImagenes);
            }
        }
        return articuloInsumoDTO;
    }

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

    public ArticuloInsumoDTO mapperJson(String articuloInsumoJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArticuloInsumoDTO articuloInsumoDTO;
        try {
            articuloInsumoDTO = objectMapper.readValue(articuloInsumoJson, ArticuloInsumoDTO.class);
            return articuloInsumoDTO;
        } catch (IOException e) {
            return null;
        }
    }


}


