package com.timeless.timeless.controllers;

import com.timeless.timeless.domain.Empleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class inicio {
    @GetMapping ("/holis")
    public Empleado prueba(){
        Empleado yo = new Empleado(12, "gurbina", new Date(), new Date());
        return yo;
    }
}
