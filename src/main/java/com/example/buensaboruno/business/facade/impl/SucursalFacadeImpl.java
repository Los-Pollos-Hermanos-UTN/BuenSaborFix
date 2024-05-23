package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.SucursalFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.SucursalMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.SucursalServiceImpl;
import com.example.buensaboruno.domain.dtos.SucursalDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalFacadeImpl extends BaseFacadeImpl<Sucursal, SucursalDTO, Long> implements SucursalFacade {


    private final SucursalMapper sucursalMapper;

    @Autowired
    private SucursalServiceImpl sucursalServiceImpl;

    public SucursalFacadeImpl(BaseService<Sucursal, Long> baseService, SucursalMapper sucursalMapper){
        super(baseService, sucursalMapper);
        this.sucursalMapper = sucursalMapper;
    }

    @Override
    public SucursalShortDTO getShort(Long id) throws Exception {
        Sucursal entity = baseService.findById(id);
        return sucursalMapper.toShortDTO(entity);
    }

    public SucursalShortDTO saveShort(SucursalShortDTO sucursalShortDTO) throws Exception {
        Sucursal entity = sucursalMapper.toEntityFromShortDTO(sucursalShortDTO);
        return sucursalMapper.toShortDTO(baseService.save(entity));
    }

    public void deleteShort(Long id) throws Exception {
        baseService.delete(id);
    }

    public List<SucursalShortDTO> findAllShort() throws Exception {
        List<Sucursal> entities = baseService.findAll();
        return sucursalMapper.toShortDTOsList(entities);
    }

    public SucursalShortDTO updateShort(Long id, SucursalShortDTO sucursalShortDTO) throws Exception {
        Sucursal entity = sucursalMapper.toEntityFromShortDTO(sucursalShortDTO);
        return sucursalMapper.toShortDTO(baseService.update(id, entity));
    }

    public List<SucursalShortDTO> findAllShortByEmpresa(Long empresaId) throws Exception {
        return sucursalServiceImpl.findAllShortByEmpresa(empresaId);
    }

    public List<SucursalDTO> findAllByEmpresa(Long empresaId) throws Exception {
        return sucursalServiceImpl.findAllByEmpresa(empresaId);
    }
}