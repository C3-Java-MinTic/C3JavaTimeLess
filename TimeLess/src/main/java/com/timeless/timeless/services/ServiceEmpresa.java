package com.timeless.timeless.services;

import com.timeless.timeless.domain.Empresa;

import java.util.ArrayList;
import java.util.Date;

public class ServiceEmpresa {

    ArrayList<Empresa> listaEmpresas = new ArrayList<Empresa>();

    public ServiceEmpresa(){
        Empresa empresa1 = new Empresa(1, "Donde Tulia", "13", "String phone", "String address",new Date(), new Date());
        listaEmpresas.add(empresa1);
    }

    public ArrayList<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(ArrayList<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }
}
