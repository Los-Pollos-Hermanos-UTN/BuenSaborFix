package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ArticuloManufacturadoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ArticuloManufacturadoMapper;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.ArticuloManufacturadoServiceImpl;
import com.example.buensaboruno.business.services.impl.ImagenArticuloServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ArticuloManufacturadoDTO;
import com.example.buensaboruno.domain.dtos.ImagenArticuloDTO;
import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.CategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArticuloManufacturadoFacadeImpl extends BaseFacadeImpl<ArticuloManufacturado, ArticuloManufacturadoDTO, Long> implements ArticuloManufacturadoFacade {

    private final ObjectMapper objectMapper;

    public ArticuloManufacturadoFacadeImpl(BaseService<ArticuloManufacturado, Long> baseService, BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDTO> baseMapper, ObjectMapper objectMapper){
        super(baseService, baseMapper);
        this.objectMapper = objectMapper;
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ArticuloManufacturadoMapper articuloManufacturadoMapper;

    @Autowired
    private ArticuloManufacturadoServiceImpl articuloManufacturadoService;

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ImagenArticuloServiceImpl imagenArticuloServiceImpl;

    public ArticuloManufacturadoDTO createArticuloManufacturado(ArticuloManufacturadoDTO articuloManufacturadoDTO) {
        ArticuloManufacturado articuloManufacturado = articuloManufacturadoMapper.toEntityWithContextMapping(articuloManufacturadoDTO, categoriaRepository);
        articuloManufacturado = articuloManufacturadoService.createArticuloManufacturado(articuloManufacturado);
        return articuloManufacturadoMapper.toDTO(articuloManufacturado);
    }

    public ArticuloManufacturadoDTO editArticuloManufacturado(ArticuloManufacturadoDTO articuloManufacturadoDTO, Long id){
        ArticuloManufacturado articuloManufacturado = articuloManufacturadoMapper.toEntityWithContextMapping(articuloManufacturadoDTO, categoriaRepository);
        try{
            articuloManufacturado = articuloManufacturadoService.editArticuloManufacturado(articuloManufacturado, id);
            return articuloManufacturadoMapper.toDTO(articuloManufacturado);
        }catch (Exception e){
            return null;
        }
    }

    public ArticuloManufacturadoDTO uploadImages(ArticuloManufacturadoDTO articuloManufacturadoDTO, MultipartFile[] files){
        if (files != null && files.length > 0) {

            // Subir las imágenes y obtener las URLs
            List<String> imageUrls = imagenArticuloServiceImpl.saveImages(files);

            // Crear un conjunto de imágenes a partir de las URLs
            Set<ImagenArticuloDTO> nuevasImagenes = imageUrls.stream()
                    .map(url -> new ImagenArticuloDTO(url))
                    .collect(Collectors.toSet());

            // Verificar si articuloManufacturadoDTO ya tiene imágenes
            if (articuloManufacturadoDTO.getImagenes() != null && !articuloManufacturadoDTO.getImagenes().isEmpty()) {
                // Mantener las imágenes existentes y agregar las nuevas
                articuloManufacturadoDTO.getImagenes().addAll(nuevasImagenes);
            } else {
                articuloManufacturadoDTO.setImagenes(nuevasImagenes);
            }
        }
        return articuloManufacturadoDTO;
    }

    public ArticuloManufacturadoDTO mapperJson(String articuloManufacturadoJson) {
        ArticuloManufacturadoDTO articuloManufacturadoDTO;
        try {
            articuloManufacturadoDTO = objectMapper.readValue(articuloManufacturadoJson, ArticuloManufacturadoDTO.class);
            return articuloManufacturadoDTO;
        } catch (IOException e) {
            return null;
        }
    }

    public List<ArticuloManufacturadoDTO> findArticuloManufacturadosByEmpresaId(Long empresaId) {
        List<ArticuloManufacturadoDTO> articuloManufacturadoDTOS = articuloManufacturadoMapper.toDTOsList(articuloManufacturadoRepository.findByEmpresaId(empresaId));
        return articuloManufacturadoDTOS;
    }
}

