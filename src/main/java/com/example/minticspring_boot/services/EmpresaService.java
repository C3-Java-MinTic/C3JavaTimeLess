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

    // crea una empresa nueva
    public Boolean crearNuevaEmpresa(Empresa empresa){

        try {
            empresaRepository.save(empresa);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;
        
        
    }

    //Lista todas las empresas
    public List<Empresa> getAllEmpresas(){

        return empresaRepository.findAll();
    }

    // borra una empresa

    public void delete (Empresa empresa){

        empresaRepository.delete(empresa);
    }

    public void deleteEmpresaById (Long id){

        empresaRepository.deleteById(id);
    }
    public Empresa buscarEmpresaId(Long id){

        Empresa emprTemp = empresaRepository.findById(id).orElse(null);

        return emprTemp;
    }
    //Buscar una empresa por id

    public Optional<Empresa> findById (Long id){

        return empresaRepository.findById(id);
    }

    public Optional<Empresa> actualizarEmpresaPorID(Long id){

        return empresaRepository.findById(id);
    }

    }
