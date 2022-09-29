package com.example.minticspring_boot.controller;


import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.minticspring_boot.services.EmpresaService;
import com.example.minticspring_boot.services.MovimientoDineroService;
import com.example.minticspring_boot.services.EmpleadoService;

import com.example.minticspring_boot.domain.Empleado;
import com.example.minticspring_boot.domain.Empresa;
import com.example.minticspring_boot.domain.MovimientoDinero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@Controller
public class FrontEndController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private MovimientoDineroService movimientoDineroService;

    @GetMapping(path="/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal){

        return "home";

    }

   
    @GetMapping(path ="/crearEmpleado")
    public String crearEmpleado (Model modelo){
        List<Empresa> listaEmpresa = empresaService.getAllEmpresas();

        modelo.addAttribute("crearemp", new Empleado());

        modelo.addAttribute("empresaemp", listaEmpresa);


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
        List<Empleado> listEmpleado = empleadoService.obtenerTodosLosEmpleados();
        modelo.addAttribute("empleados", listEmpleado);
        modelo.addAttribute("crearempresa", new Empresa());

        return "crearEmpresa";

    }

    @GetMapping(path ="/verempleados")
    public String verEmpleados (Model modelo){

        List<Empleado> listEmpleado = empleadoService.obtenerTodosLosEmpleados();
        modelo.addAttribute("empleados", listEmpleado);

    

        return "verEmpleado";

    }

    @GetMapping(path ="/verempresas")
    public String verEmpresas (Model modelo){

        List<Empresa> listEmpresa = empresaService.getAllEmpresas();
        modelo.addAttribute("empresa", listEmpresa);

    

        return "verEmpresas";

    }

    @GetMapping(path ="/editarempresa/{id}")
    public String editarEmpresa (Model modelo, @PathVariable("id") Long id){

        Empresa emprtemp = empresaService.buscarEmpresaId(id);
        List<Empleado> listEmpleado = empleadoService.obtenerTodosLosEmpleados();
        modelo.addAttribute("empleados", listEmpleado);
        modelo.addAttribute("editarempr", emprtemp);

        return "editarEmpresa";

    }

    @GetMapping(path="/dashboard")
    public String dashboard(Model modelo, @AuthenticationPrincipal OidcUser principal){

        if(principal != null){

            List<Empresa> listaEmpresa = empresaService.getAllEmpresas();

            List<String> nombreEmpresa = new ArrayList<String>();
            for (Empresa empresa : listaEmpresa) {
                nombreEmpresa.add(empresa.getName());
            
        }
        
        List<Empleado> listEmpleado = empleadoService.obtenerTodosLosEmpleados();
        modelo.addAttribute("empleados", listEmpleado);
        modelo.addAttribute("profile", principal.getClaims());

        return "dashboard";


    }

        return "home";



    }


    @GetMapping(path="/vermovimientos")
    public String getMovimientoDinero(Model modelo){
        List<MovimientoDinero> listMovimientoDinero = movimientoDineroService.obtenerTodosLosMovimientos();
        modelo.addAttribute("movimientos", listMovimientoDinero);

        return "verMovimientos";
    }

    @GetMapping(path ="/crearMovimiento")
    public String crearMovimiento (Model modelo){

        List<Empleado> listEmpleado = empleadoService.obtenerTodosLosEmpleados();
        List<Empresa> listEmpresa = empresaService.getAllEmpresas();
        modelo.addAttribute("empleados", listEmpleado);
        modelo.addAttribute("empresas",listEmpresa);
        modelo.addAttribute("crearmovimiento", new MovimientoDinero());
        return "crearMovimiento";

    }

    @GetMapping(path ="/editarMovimiento/{id}")
    public String editarMovimiento (Model modelo, @PathVariable("id") Long id){
        MovimientoDinero movtemp = movimientoDineroService.buscarMovimienotId(id);
        List<Empleado> listEmpleado = empleadoService.obtenerTodosLosEmpleados();
        List<Empresa> listEmpresa = empresaService.getAllEmpresas();
        modelo.addAttribute("empleados", listEmpleado);
        modelo.addAttribute("empresas",listEmpresa);
        modelo.addAttribute("editarmov", movtemp);
        return "editarMovimiento";
    }



}
