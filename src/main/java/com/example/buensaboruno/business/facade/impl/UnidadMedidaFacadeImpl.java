package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.UnidadMedidaFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.BaseMapper;
import com.example.buensaboruno.business.mapper.UnidadMedidaMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.domain.dtos.UnidadMedidaDTO;
import com.example.buensaboruno.domain.entities.UnidadMedida;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaFacadeImpl extends BaseFacadeImpl<UnidadMedida, UnidadMedidaDTO, Long> implements UnidadMedidaFacade {
    public UnidadMedidaFacadeImpl(BaseService<UnidadMedida, Long> baseService, BaseMapper<UnidadMedida, UnidadMedidaDTO> baseMapper){
        super(baseService, baseMapper);
    }

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    @Autowired
    private UnidadMedidaMapper unidadMedidaMapper;


    public List<UnidadMedidaDTO> findUnidadesMedidaByEmpresaId(Long empresaId) {
        List<UnidadMedidaDTO> unidadMedidaDTOS = unidadMedidaMapper.toDTOsList(unidadMedidaRepository.findByEmpresaId(empresaId));
        return unidadMedidaDTOS;
    }
}