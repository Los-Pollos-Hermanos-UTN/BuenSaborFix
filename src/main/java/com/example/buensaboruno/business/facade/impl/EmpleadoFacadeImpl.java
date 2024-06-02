package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.EmpleadoFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.EmpleadoMapper;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.EmpleadoServiceImpl;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.dtos.EmpleadoDTO;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.Empleado;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmpleadoFacadeImpl extends BaseFacadeImpl<Empleado, EmpleadoDTO, Long> implements EmpleadoFacade {

    private final ObjectMapper objectMapper;

    public EmpleadoFacadeImpl(BaseService<Empleado, Long> baseService, BaseMapper<Empleado, EmpleadoDTO> baseMapper, ObjectMapper objectMapper){
        super(baseService, baseMapper);
        this.objectMapper = objectMapper;
    }

    @Autowired
    private EmpleadoMapper empleadoMapper;

    @Autowired
    private EmpleadoServiceImpl empleadoServiceImpl;


    public EmpleadoDTO mapperJson(String empleadoJson) {
        try {
            return objectMapper.readValue(empleadoJson, EmpleadoDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to map JSON to EmpleadoDTO", e);
        }
    }

    public EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO){
        Empleado empleado = empleadoMapper.toEntity(empleadoDTO);
        empleado = empleadoServiceImpl.createEmpleado(empleado);
        return empleadoMapper.toDTO(empleado);
    }

    public EmpleadoDTO editEmpleado(EmpleadoDTO empleadoDTO, Long id){
        Empleado empleado = empleadoMapper.toEntity(empleadoDTO);
        try {
            empleado = empleadoServiceImpl.editEmpleado(empleado, id);
            return empleadoMapper.toDTO(empleado);
        }catch (Exception e){
            return null;
        }
    }
}
