package com.example.minticspring_boot.controller;
import com.example.minticspring_boot.domain.Empleado;
import com.example.minticspring_boot.services.EmpleadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoServices empleadoServices;

    // Consulta todos los empleados registrados
    @GetMapping(path="/example/minticspring_boot/ver_empleados")
    public List<Empleado> all_empleados(){
        return empleadoServices.getAllEmpleadoList();
    }

    // Crear empleado
    @PostMapping (value="example/minticspring_boot/crear_empleado")
    public void addEmpleado(Empleado empleado){
        empleadoServices.addEmpleado(empleado);
    }

}
