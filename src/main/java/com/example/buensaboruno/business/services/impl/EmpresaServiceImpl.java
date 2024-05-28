package com.example.buensaboruno.business.services.impl;


import com.example.buensaboruno.business.services.EmpresaService;
import com.example.buensaboruno.business.services.base.BaseServiceImpl;
import com.example.buensaboruno.domain.entities.Empresa;
import com.example.buensaboruno.repositories.base.BaseRepository;
import com.example.buensaboruno.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl extends BaseServiceImpl<Empresa, Long> implements EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(BaseRepository<Empresa, Long> baseRepository, EmpresaRepository empresaRepository) {
        super(baseRepository);
        this.empresaRepository=empresaRepository;
    }

    public Empresa createEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public Empresa editEmpresa(Empresa empresa, Long id) throws Exception{
        return update(id, empresa);
    }
}
