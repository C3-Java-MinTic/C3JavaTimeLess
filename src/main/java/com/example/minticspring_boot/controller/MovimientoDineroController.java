package com.example.minticspring_boot.controller;

import com.example.minticspring_boot.domain.Empleado;
import com.example.minticspring_boot.domain.MovimientoDinero;
import com.example.minticspring_boot.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/minticspring_boot/movimientos/")
public class MovimientoDineroController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;

    //Metodo Post para crear un nuevo movimiento
    @PostMapping
    private ResponseEntity<MovimientoDinero> guardarMovimientoNuevo(@RequestBody MovimientoDinero movimientoDinero){
        MovimientoDinero movimientoDinero1 = movimientoDineroService.crearNuevoMovimiento(movimientoDinero);

        try{
            return ResponseEntity.created(new URI("/minticspring_boot/movimientos"+movimientoDinero1.getId())).body(movimientoDinero1);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //Metodo para crear un nuevo movimiento desde frontend
    @PostMapping(path = "/insertarMovimiento")
    public void insertarMovimiento(@ModelAttribute MovimientoDinero movimientoDinero, Model modelo){
        modelo.addAttribute(movimientoDinero);
        movimientoDineroService.crearNuevoMovimiento(movimientoDinero);
        //return new RedirectView("/intro");
    }

    //Metodo Get para listar todos los movimientos
    @GetMapping
    private ResponseEntity<List<MovimientoDinero>> listarTodosLosMovimientos(){
        return ResponseEntity.ok(movimientoDineroService.obtenerTodosLosMovimientos());
    }

    //Metodo Delete para eliminar un empleado
    @DeleteMapping
    private ResponseEntity<Void> eliminarMovimiento(@RequestBody MovimientoDinero movimientoDinero){
        movimientoDineroService.borrarMovimiento(movimientoDinero);
        return ResponseEntity.ok().build();
    }

    //Metodo para obtener un empleado por id
    @GetMapping(value = "{id}")
    private ResponseEntity<Optional<MovimientoDinero>> listarMovimientoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(movimientoDineroService.encontrarMovimientoPorId(id));
    }

    //Metodo Put Actualizar un empleado
    @PutMapping(value="/update/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimientoDinero> actualizarMovimientos(@PathVariable Long id, @RequestBody MovimientoDinero movimientoDinero){

        try{
            MovimientoDinero movimientoDinero1 = movimientoDineroService.encontrarMovimientoPorId(id).get();
            movimientoDinero1.setConcept(movimientoDinero.getConcept());
            movimientoDinero1.setAmount(movimientoDinero.getAmount());
            movimientoDinero1.setUpdateAt(movimientoDinero.getUpdateAt());
            movimientoDinero1.setCreatedAt(movimientoDinero.getCreatedAt());
            return new ResponseEntity<MovimientoDinero>(movimientoDineroService.crearNuevoMovimiento(movimientoDinero1), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Metodo Patch actualizar datos
    @PatchMapping(value="/update/{id}/{concept}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimientoDinero> actualizacionMovimientos(@PathVariable Long id, @PathVariable String concept){

        try{
            MovimientoDinero movimientoDinero = movimientoDineroService.encontrarMovimientoPorId(id).get();
            movimientoDinero.setConcept(concept);

            return new ResponseEntity<MovimientoDinero>(movimientoDineroService.crearNuevoMovimiento(movimientoDinero), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
