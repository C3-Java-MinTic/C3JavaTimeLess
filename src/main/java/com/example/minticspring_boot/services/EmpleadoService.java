package com.example.minticspring_boot.services;

import com.example.minticspring_boot.domain.Empleado;
import com.example.minticspring_boot.repository.EmpleadoRepository;
import com.example.minticspring_boot.repository.EmpresaRepository;
import com.example.minticspring_boot.repository.Permisos;
import com.example.minticspring_boot.repository.PermisosRepository;
import com.example.minticspring_boot.util.Enum_RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private PermisosRepository permisosRepository;

    //@Autowired
    //private EmpresaRepository empresaRepository;

    // crear un empleado nuevo

    public Empleado crearNuevoEmpleado(Empleado empleado){
        
        return empleadoRepository.save(empleado);
    }

    //Listar todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados(){

        return empleadoRepository.findAll();
    }

    // Eliminar un empleado
    public void delete(Empleado empleado){

        empleadoRepository.delete(empleado);
    }

    //Buscar un empleado por id

    public Optional<Empleado> encontrarporId(Long id) {

        return empleadoRepository.findById(id);
    }


    public Boolean insertarEmpleadoRol(Empleado empleado){
        if(empleado.getRole().equals(Enum_RoleName.Admin)){
            empleadoRepository.save(empleado);
            Permisos permisosTemp = new Permisos( true, true, true, true, true, empleado);
            permisosRepository.save(permisosTemp);

        }else if(empleado.getRole().equals(Enum_RoleName.Operario)){
            empleadoRepository.save(empleado);
            Permisos permisosTemp = new Permisos( false, false, false, false, true, empleado);
            permisosRepository.save(permisosTemp);

        } else {
            System.err.println("No se pudo obtener el rol ");

            return Boolean.FALSE;

        }

        return Boolean.TRUE;

    }

    //public boolean insertarEmpleado(Empleado empleado){

        //try{
            //empresaRepository.findById(empleado.getIdEmpresa());
            //empleadoRepository.save(empleado);

        //}catch (Exception e){
            //return Boolean.FALSE;

    //}

    //}
}

