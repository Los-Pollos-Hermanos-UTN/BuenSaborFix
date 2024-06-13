package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpresaFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.EmpresaMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.EmpresaServiceImpl;
import com.example.buensaboruno.business.services.impl.ImagenEmpresaServiceImpl;
import com.example.buensaboruno.domain.dtos.*;
import com.example.buensaboruno.domain.dtos.shortDTO.EmpresaShortDTO;
import com.example.buensaboruno.domain.entities.Empleado;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.repositories.EmpleadoRepository;
import com.example.buensaboruno.repositories.EmpresaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmpresaFacadeImpl extends BaseFacadeImpl<Empresa, EmpresaDTO, Long> implements EmpresaFacade {

    @Autowired
    private EmpresaServiceImpl empresaService;

    @Autowired
    private EmpresaMapper empresaMapper;

    @Autowired
    private ImagenEmpresaServiceImpl imagenEmpresaServiceImpl;

    private final ObjectMapper objectMapper;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaFacadeImpl(BaseService<Empresa, Long> baseService, EmpresaMapper empresaMapper, ObjectMapper objectMapper){
        super(baseService, empresaMapper);
        this.objectMapper = objectMapper;
    }

    @Override
    public EmpresaShortDTO getShort(Long id) throws Exception {
        Empresa entity = baseService.findById(id);
        return empresaMapper.toShortDTO(entity);
    }

    public EmpresaShortDTO saveShort(EmpresaShortDTO empresaShortDTO) throws Exception {
        Empresa entity = empresaMapper.toEntityFromShortDTO(empresaShortDTO);
        return empresaMapper.toShortDTO(baseService.save(entity));
    }

    public void deleteShort(Long id) throws Exception {
        baseService.delete(id);
    }

    public List<EmpresaShortDTO> findAllShort() throws Exception {
        List<Empresa> entities = baseService.findAll();
        return empresaMapper.toShortDTOsList(entities);
    }

    public EmpresaShortDTO updateShort(Long id, EmpresaShortDTO empresaShortDTO) throws Exception {
        Empresa entity = empresaMapper.toEntityFromShortDTO(empresaShortDTO);
        return empresaMapper.toShortDTO(baseService.update(id, entity));
    }

    public EmpresaDTO mapperJson(String empresaJson) {
        try {
            return objectMapper.readValue(empresaJson, EmpresaDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to map JSON to SucursalDTO", e);
        }
    }

    public EmpresaDTO uploadImages(EmpresaDTO empresaDTO, MultipartFile[] files){
        if (files != null && files.length > 0) {

            // Subir las imágenes y obtener las URLs
            List<String> imageUrls = imagenEmpresaServiceImpl.saveImages(files);

            // Crear un conjunto de imágenes a partir de las URLs
            Set<ImagenEmpresaDTO> nuevasImagenes = imageUrls.stream()
                    .map(url -> new ImagenEmpresaDTO(url))
                    .collect(Collectors.toSet());

            // Verificar si articuloInsumoDTO ya tiene imágenes
            if (empresaDTO.getImagenes() != null && !empresaDTO.getImagenes().isEmpty()) {
                // Mantener las imágenes existentes y agregar las nuevas
                empresaDTO.getImagenes().addAll(nuevasImagenes);
            } else {
                empresaDTO.setImagenes(nuevasImagenes);
            }
        }
        return empresaDTO;
    }

    public EmpresaDTO createEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = empresaMapper.toEntity(empresaDTO);
        empresa = empresaService.createEmpresa(empresa);
        return empresaMapper.toDTO(empresa);
    }

    public EmpresaDTO editEmpresa(EmpresaDTO empresaDTO, Long id){
        Empresa empresa = empresaMapper.toEntity(empresaDTO);
        try {
            empresa = empresaService.editEmpresa(empresa, id);
            return empresaMapper.toDTO(empresa);
        }catch (Exception e){
            return null;
        }
    }

    public List<EmpresaShortDTO> listEmpresasByEmpleadoEmail(String email){
        Optional<Empleado> empleado = empleadoRepository.findByEmail(email);
        if(empleado.isPresent()){
            List<Empresa> empresas = empresaRepository.findEmpresasByEmpleadoId(empleado.get().getId());
            return empresaMapper.toShortDTOsList(empresas);
        }
        return null;
    }
}

