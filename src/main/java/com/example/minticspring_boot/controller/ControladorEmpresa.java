package com.example.minticspring_boot.controller;

import com.example.minticspring_boot.domain.Empresa;
import com.example.minticspring_boot.services.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorEmpresa {

    @Autowired
    ServicioEmpresa servicio_empresa;

    //Consultar todas las empresas
    @GetMapping(path="/example/minticspring_boot/enterprises")
    public List<Empresa> allEmpresas(){
        return servicio_empresa.getAllEmpresasList();
    }

    @PostMapping(path="/example/minticspring_boot/create_enterprises", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEmpresa(@RequestBody Empresa empresa){
        servicio_empresa.addEmpresa(empresa);
    }
}
