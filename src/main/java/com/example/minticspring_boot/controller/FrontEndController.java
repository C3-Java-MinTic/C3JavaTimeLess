package com.example.minticspring_boot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.minticspring_boot.services.EmpleadoService;
import com.example.minticspring_boot.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class FrontEndController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(path="/")
    public String home(){

        return "home";

    }

    @GetMapping(path="/intro")
    public String intro(Model modelo){

        List<Empleado> listEmpleado = empleadoService.obtenerTodosLosEmpleados();
        modelo.addAttribute("empleados", listEmpleado);

        return "intro";

    }

    @GetMapping(path ="/crearEmpleado")
    public String crearEmpleado (Model modelo){

        modelo.addAttribute("crearemp", new Empleado());

        return "crearEmpleado";

    }

}
