package com.example.minticspring_boot.services;

import com.example.minticspring_boot.domain.Empleado;
import com.example.minticspring_boot.domain.Empresa;
import com.example.minticspring_boot.repository.EmpleadoRepository;
import com.example.minticspring_boot.repository.EmpresaRepository;
import com.example.minticspring_boot.repository.Permisos;
import com.example.minticspring_boot.util.Enum_RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

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

    //Buscar una empresa por id

    public Optional<Empresa> findById (Long id){

        return empresaRepository.findById(id);
    }

    public Optional<Empresa> actualizarEmpresaPorID(Long id){

        return empresaRepository.findById(id);
    }

    }
