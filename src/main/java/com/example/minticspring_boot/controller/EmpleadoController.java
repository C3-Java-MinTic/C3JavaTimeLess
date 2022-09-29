package com.example.minticspring_boot.controller;
import com.example.minticspring_boot.domain.Empleado;
import com.example.minticspring_boot.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/minticspring_boot/empleado/")
public class EmpleadoController {

@Autowired
    private EmpleadoService empleadoService;

// Metodo POST para crear un nuevo empleado
    @PostMapping (path="crearEmpleado", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado){
        
        boolean salida = empleadoService.crearNuevoEmpleado(empleado);
        
        if(salida == true){

            return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);

        } else{

            return new ResponseEntity("Error de ejecución", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        }
    

    //Método Get para listar todos los empleados

    @GetMapping
    private ResponseEntity<List<Empleado>> listarEmpleados(){
        return ResponseEntity.ok(empleadoService.obtenerTodosLosEmpleados());
    }

    //Eliminar un empleado
    @DeleteMapping("/eliminarEmpleado/{id}")
    private RedirectView eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.deleteEmpleadoById(id);
        return new RedirectView("/verempleados");
    }

    //Obtener un empleado por id

    @GetMapping(value="{id}")
    private ResponseEntity<Optional<Empleado>> listarEmpleadoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(empleadoService.encontrarporId(id));
    }


    //Metodo Put Actualizar un empleado
    @PutMapping(path="/actualizarEmpleado")
    public RedirectView actualizarEmpleado(@ModelAttribute Empleado empleado, Model modelo){

        modelo.addAttribute(empleado);
        if(empleadoService.crearNuevoEmpleado(empleado).equals(Boolean.TRUE)){
            return new RedirectView("/verempleados");
        } else {

            return new RedirectView("/error");
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
        return new RedirectView("/verempleados");

     }else{
        return new RedirectView("/error");
     }
    

  }

    //Metodo Patch
    //@PatchMapping(value="/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //public ResponseEntity<Empleado> actualizacionParcialEmpleado(@PathVariable Long id, @PathVariable String email, @PathVariable LocalDate createdAt, @PathVariable LocalDate updatedAt){
        //try{
            //Empleado empleado = empleadoService.encontrarporId(id).get();
            //empleado.setEmail(email);
            //empleado.setCreatedAt(createdAt);
            //empleado.setUpdatedAt(updatedAt);
            //return new ResponseEntity<Empleado>(empleadoService.crearNuevoEmpleado(empleado), HttpStatus.OK);
        //} catch (Exception e){
            //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        //}
    //}
}
