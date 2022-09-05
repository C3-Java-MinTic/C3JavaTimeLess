package com.example.minticspring_boot.services;

import com.example.minticspring_boot.domain.Empleado;
import org.springframework.data.util.Predicates;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpleadoServices {

    private List<Empleado> listaEmpleados = new ArrayList<>(Arrays.asList(
            new Empleado(1, "tararin_tararan@gmail.com", LocalDate.now(), LocalDate.now()),
            new Empleado(2, "georgeboy@gmail.com", LocalDate.now(), LocalDate.now())

    ));

    public List<Empleado> getAllEmpleadoList(){
        return listaEmpleados;
    }


    public void addEmpleado(Empleado empleado){
        listaEmpleados.add(new Empleado(3,"lenovo@gmail.com",LocalDate.now(), LocalDate.now()));
        listaEmpleados.add(new Empleado(4,"casanova@gmail.com",LocalDate.now(), LocalDate.now()));

    }

}
