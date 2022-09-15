package com.example.minticspring_boot.services;

import com.example.minticspring_boot.domain.Empresa;
import com.example.minticspring_boot.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // crea una empresa nueva
    public Empresa create(Empresa empresa){
        return empresaRepository.save(empresa);

    }

    //Lista todas las empresas
    public List<Empresa> getAllEmpresas(){
        return empresaRepository.findAll();
    }

    // borra una empresa

    public void delete (Empresa empresa){
        empresaRepository.delete(empresa);
    }

    //Buscar una empresa

    public Optional<Empresa> findById (Long id){
        return empresaRepository.findById(id);
    }


}
