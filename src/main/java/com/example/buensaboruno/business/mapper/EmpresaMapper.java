package com.example.buensaboruno.business.mapper;

import com.example.buensaboruno.domain.dtos.EmpresaDTO;
import com.example.buensaboruno.domain.entities.Empresa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpresaMapper extends BaseMapper<Empresa, EmpresaDTO>{
    EmpresaDTO toDTO(Empresa source);
    Empresa toEntity(EmpresaDTO source);
    List<EmpresaDTO> toDTOsList(List<Empresa> source);
    List<Empresa> toEntitiesList(List<EmpresaDTO> source);
}
