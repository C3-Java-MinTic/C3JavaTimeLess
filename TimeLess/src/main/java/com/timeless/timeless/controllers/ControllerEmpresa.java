package com.timeless.timeless.controllers;

import com.timeless.timeless.domain.Empleado;
import com.timeless.timeless.domain.Empresa;
import com.timeless.timeless.services.ServiceEmpresa;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ControllerEmpresa {


    ServiceEmpresa serviceEmpresa = new ServiceEmpresa();
    long contadorId=2;

    @GetMapping("/enterprises")
    public ArrayList<Empresa> getAll(){
        return serviceEmpresa.getListaEmpresas();
    }

    @PostMapping("/enterprises")
    Empresa postOne(@RequestBody Empresa newEmpresa) {
        newEmpresa.setId(contadorId);
        serviceEmpresa.getListaEmpresas().add(newEmpresa);
        contadorId+=1;
        return newEmpresa;
    }

    @GetMapping("/enterprises/{id}")
    Empresa getOne(@PathVariable("id") long id){
        Empresa foundedEmpresa = new Empresa();
        Empresa evaluatedEmpresa;
        for(long i=0;i<serviceEmpresa.getListaEmpresas().toArray().length;i++){
            evaluatedEmpresa = serviceEmpresa.getListaEmpresas().get((int)i);
            long evaluatedId = evaluatedEmpresa.getId();
            if(evaluatedId==id){
                foundedEmpresa = serviceEmpresa.getListaEmpresas().get((int)i);
            }
        }
        return foundedEmpresa;
    }

    @PatchMapping("/enterprises/{id}")
    void editOne(@PathVariable long id,@RequestBody Empresa newData) {
        Empresa editedEmpresa=new Empresa();
        for (int i = 0; i < serviceEmpresa.getListaEmpresas().toArray().length; i++) {
            if (i == id) {
                serviceEmpresa.getListaEmpresas().set(i,newData);
            }
        }
    }

    @DeleteMapping("/enterprises/{id}")
    void deleteOne(@PathVariable long id){
        for(long i=0;i<serviceEmpresa.getListaEmpresas().toArray().length;i++){
            if(i==id){
                serviceEmpresa.getListaEmpresas().remove((int)i);
                System.out.println(i);
            }
        }
    }

}
