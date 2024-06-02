package com.example.buensaboruno.business.facade.impl;

import com.example.buensaboruno.business.facade.ClienteFacade;
import com.example.buensaboruno.business.facade.base.BaseFacadeImpl;
import com.example.buensaboruno.business.mapper.ClienteMapper;
import com.example.buensaboruno.business.mapper.base.BaseMapper;
import com.example.buensaboruno.business.services.base.BaseService;
import com.example.buensaboruno.business.services.impl.ClienteServiceImpl;
import com.example.buensaboruno.domain.dtos.ArticuloInsumoDTO;
import com.example.buensaboruno.domain.dtos.ClienteDTO;
import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.dtos.PromocionDTO;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.Empresa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClienteFacadeImpl extends BaseFacadeImpl<Cliente, ClienteDTO, Long> implements ClienteFacade {

    private final ObjectMapper objectMapper;

    public ClienteFacadeImpl(BaseService<Cliente, Long> baseService, BaseMapper<Cliente, ClienteDTO> baseMapper, ObjectMapper objectMapper){
        super(baseService, baseMapper);
        this.objectMapper = objectMapper;
    }

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    public ClienteDTO mapperJson(String clienteJson) {
        try {
            return objectMapper.readValue(clienteJson, ClienteDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to map JSON to ClienteDTO", e);
        }
    }

    public ClienteDTO createCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente = clienteServiceImpl.createCliente(cliente);
        return clienteMapper.toDTO(cliente);
    }

    public ClienteDTO editCliente(ClienteDTO clienteDTO, Long id){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        try {
            cliente = clienteServiceImpl.editCliente(cliente, id);
            return clienteMapper.toDTO(cliente);
        }catch (Exception e){
            return null;
        }
    }
}
