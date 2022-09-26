package com.example.minticspring_boot.controller;

import com.example.minticspring_boot.domain.Empresa;
import com.example.minticspring_boot.services.EmpresaService;
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
@RequestMapping("/minticspring_boot/empresa/")
public class ControladorEmpresa {

    @Autowired
    private EmpresaService empresaService;

    // Metodo POST para crear un nuevo empleado
    @PostMapping (path="crearEmpresa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa){
        
        boolean salida = empresaService.crearNuevaEmpresa(empresa);
        
        if(salida == true){

            return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);

        } else{

            return new ResponseEntity("Error de ejecución", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        }

    

    @GetMapping
    private ResponseEntity<List<Empresa>> listarEmpresas (){
        return ResponseEntity.ok(empresaService.getAllEmpresas());

    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarEmpresa (@RequestBody Empresa empresa){
        empresaService.delete(empresa);
        return ResponseEntity.ok().build();

    }

    @GetMapping(value="{id}")
    private ResponseEntity<Optional<Empresa>> listarEmpresaPorId (@PathVariable("id") Long id){
        return ResponseEntity.ok(empresaService.findById(id));

    }

   @PostMapping(path = "/crearEmpresa")
   public RedirectView insertarEmpresa(@ModelAttribute Empresa empresa, Model modelo){
     modelo.addAttribute(empresa);
     if (empresaService.crearNuevaEmpresa(empresa).equals(Boolean.TRUE)){
        return new RedirectView("/intro");

     }else{
        return new RedirectView("/error");
     }
    
}
}

    //@PutMapping(value="/update/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    //public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa){

      // try{
        //   Empresa empresa1 = empresaService.findById(id).get();
          // empresa1.setName(empresa.getName());
           //empresa1.setAddress(empresa.getAddress());
           //empresa1.setDocument(empresa.getDocument());
           //empresa1.setPhone(empresa.getPhone());
           //return new ResponseEntity<Empresa>(empresaService.crearNuevaEmpresa(empresa1), HttpStatus.OK);
       //} catch (Exception e){
           //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       //}
    //}

    /*@PatchMapping(value="/update/{id}/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> actualizacionParcialNombre(@PathVariable Long id, @PathVariable String name ){
        try{
            Empresa empresa = empresaService.findById(id).get();
            empresa.setName(name);
            return new ResponseEntity<Empresa>(empresaService.create(empresa), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}*/
