package com.example.minticspring_boot.services;

import com.example.minticspring_boot.domain.Empleado;
import com.example.minticspring_boot.domain.MovimientoDinero;
import com.example.minticspring_boot.repository.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoDineroService {

    @Autowired
    private MovimientoDineroRepository movimientoDineroRepository;

    // Crear un movimiento de dinero nuevo

    public MovimientoDinero crearNuevoMovimiento(MovimientoDinero movimientoDinero){

        return movimientoDineroRepository.save(movimientoDinero);
    }

    // Listar todos los movimientos

    public List<MovimientoDinero> obtenerTodosLosMovimientos(){
        return movimientoDineroRepository.findAll();
    }

    //Eliminar un movimiento de dinero
    public void borrarMovimiento(MovimientoDinero movimientoDinero){
        movimientoDineroRepository.delete(movimientoDinero);
    }

    //Buscar un movimiento por id
    public Optional<MovimientoDinero> encontrarMovimientoPorId(Long id){
        return movimientoDineroRepository.findById(id);
    }
}
