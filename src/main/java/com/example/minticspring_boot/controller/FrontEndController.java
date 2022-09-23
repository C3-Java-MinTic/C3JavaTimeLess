package com.example.minticspring_boot.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.minticspring_boot.services.EmpleadoService;

import com.example.minticspring_boot.domain.Empleado;
import com.example.minticspring_boot.domain.Empresa;
import com.example.minticspring_boot.repository.EmpresaRepository;

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

        modelo.addAttribute("empresaemp", new Empresa());


        return "crearEmpleado";

    }

    @GetMapping(path ="/editarEmpleado/{id}")
    public String editarEmpleado (Model modelo, @PathVariable("id") Long id){

        Empleado emptemp = empleadoService.buscarEmpleadoId(id);
        modelo.addAttribute("editaremp", emptemp);

        return "editarEmpleado";

    }

    @GetMapping(path ="/crearEmpresa")
    public String crearEmpresa (Model modelo){

        modelo.addAttribute("crearempresa", new Empresa());

        return "crearEmpresa";

    }

}
