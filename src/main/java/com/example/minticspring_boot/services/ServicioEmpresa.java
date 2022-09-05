package com.example.minticspring_boot.services;

import com.example.minticspring_boot.domain.Empresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ServicioEmpresa {

    private List<Empresa> listaEmpresas = new ArrayList<>(Arrays.asList(
           new Empresa(1, "Empresa 1", "344333434", "3005130474", "Carrera 15 n 48 - 78", new Date(122,5,3), new Date(122,9,3)),
            new Empresa(2, "Empresa 2", "344333434", "30051474", "Calle 23 n 35 - 78", new Date(122,5,3), new Date(122,9, 3))
    ));

    public List<Empresa> getAllEmpresasList(){
        return listaEmpresas;
    }

    public void addEmpresa(Empresa empresa){
        listaEmpresas.add(empresa);
    }
}
