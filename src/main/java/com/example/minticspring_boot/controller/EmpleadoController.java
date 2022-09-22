package com.example.minticspring_boot.controller;
import com.example.minticspring_boot.domain.Empleado;
import com.example.minticspring_boot.domain.Empresa;
import com.example.minticspring_boot.services.EmpleadoService;
import com.example.minticspring_boot.util.Enum_RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/minticspring_boot/empleado/")
public class EmpleadoController {

@Autowired
    private EmpleadoService empleadoService;

// Metodo POST para crear un nuevo empleado
    @PostMapping
    private ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
        Empleado empleado1 = empleadoService.crearNuevoEmpleado(empleado);

        try{
            return ResponseEntity.created(new URI("/minticspring_boot/empleado"+empleado1.getId())).body(empleado1);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //Método Get para listar todos los empleados

    @GetMapping
    private ResponseEntity<List<Empleado>> listarEmpleados(){
        return ResponseEntity.ok(empleadoService.obtenerTodosLosEmpleados());
    }

    //Eliminar un empleado
    @DeleteMapping
    private ResponseEntity<Void> eliminarEmpleado(@RequestBody Empleado empleado){
        empleadoService.delete(empleado);
        return ResponseEntity.ok().build();
    }

    //Obtener un empleado por id

    @GetMapping(value="{id}")
    private ResponseEntity<Optional<Empleado>> listarEmpleadoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(empleadoService.encontrarporId(id));
    }


    //Metodo Put Actualizar un empleado
    @PutMapping(value="/update/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado){

        try{
            Empleado empleado1 = empleadoService.encontrarporId(id).get();
            empleado1.setEmail(empleado.getEmail());
            empleado1.setUpdatedAt(empleado.getUpdatedAt());
            empleado1.setCreatedAt(empleado.getCreatedAt());
            return new ResponseEntity<Empleado>(empleadoService.crearNuevoEmpleado(empleado1), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //@PostMapping
    //@RequestMapping(value = "/insertarEmpleadoRol", method = RequestMethod.POST)
    //public void insertarEmpleadoRol(@RequestBody Empleado empleado){
      //empleadoService.insertarEmpleadoRol(empleado);

   //}

   @PostMapping(path = "/insertarEmpleadoRol")
   public RedirectView insertarEmpleadoRol(@ModelAttribute Empleado empleado, Model modelo){
     modelo.addAttribute(empleado);
     if (empleadoService.insertarEmpleadoRol(empleado).equals(Boolean.TRUE)){
        return new RedirectView("/intro");

     }else{
        return new RedirectView("/error");
     }
    

  }

    //Metodo Patch
    @PatchMapping(value="/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> actualizacionParcialEmpleado(@PathVariable Long id, @PathVariable String email, @PathVariable LocalDate createdAt, @PathVariable LocalDate updatedAt){
        try{
            Empleado empleado = empleadoService.encontrarporId(id).get();
            empleado.setEmail(email);
            empleado.setCreatedAt(createdAt);
            empleado.setUpdatedAt(updatedAt);
            return new ResponseEntity<Empleado>(empleadoService.crearNuevoEmpleado(empleado), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
