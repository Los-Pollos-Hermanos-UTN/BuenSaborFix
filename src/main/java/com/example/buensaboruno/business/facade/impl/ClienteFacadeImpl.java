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
import com.example.buensaboruno.repositories.ClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

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

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO mapperJson(String clienteJson) {
        try {
            return objectMapper.readValue(clienteJson, ClienteDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to map JSON to ClienteDTO", e);
        }
    }

    public ClienteDTO createCliente(ClienteDTO clienteDTO) throws NoSuchAlgorithmException {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.setContrasenia(encryptPassword(clienteDTO.getContrasenia()));
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

    public boolean checkPassword(Cliente cliente, String contrasenia) throws NoSuchAlgorithmException {
        return cliente.getContrasenia().equals(encryptPassword(contrasenia));
    }

    public ClienteDTO login(String email, String contrasenia) throws NoSuchAlgorithmException {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        if (cliente.isPresent()) {
            if (checkPassword(cliente.get(), contrasenia)) {
                return clienteMapper.toDTO(cliente.get());
            } else {
                throw new IllegalArgumentException("Contraseña incorrecta");
            }
        } else {
            throw new IllegalArgumentException("Cliente no encontrado");
        }
    }

    public String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
