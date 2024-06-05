package com.example.buensaboruno.business.services.impl;

import com.example.buensaboruno.business.mapper.SucursalMapper;
import com.example.buensaboruno.business.services.SucursalService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.dtos.SucursalDTO;
import com.example.buensaboruno.domain.dtos.shortDTO.SucursalShortDTO;
import com.example.buensaboruno.domain.entities.Sucursal;
import com.example.buensaboruno.repositories.base.BaseRepository;
import com.example.buensaboruno.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImpl extends BaseServiceImpl<Sucursal, Long> implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private SucursalMapper sucursalMapper;

    public SucursalServiceImpl(BaseRepository<Sucursal, Long> baseRepository, SucursalRepository sucursalRepository) {
        super(baseRepository);
        this.sucursalRepository=sucursalRepository;
    }

    public List<SucursalShortDTO> findAllShortByEmpresa(Long empresaId) throws Exception {
        List<Sucursal> entities = sucursalRepository.findAllByEmpresaId(empresaId);
        return sucursalMapper.toShortDTOsList(entities);
    }

    public List<SucursalDTO> findAllByEmpresa(Long empresaId) throws Exception {
        List<Sucursal> entities = sucursalRepository.findAllByEmpresaId(empresaId);
        return sucursalMapper.toDTOsList(entities);
    }

    public Sucursal createSucursal(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    public Sucursal editSucursal(Sucursal sucursal, Long id) throws Exception{
        return update(id, sucursal);
    }
}
