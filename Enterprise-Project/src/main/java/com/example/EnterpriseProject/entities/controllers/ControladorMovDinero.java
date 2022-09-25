package com.example.EnterpriseProject.entities.controllers;


import com.example.EnterpriseProject.entities.Empleado;
import com.example.EnterpriseProject.entities.movimientoDinero;
import com.example.EnterpriseProject.services.ServicioMovEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class ControladorMovDinero {

    @Autowired
    private ServicioMovEmpleado servicioMovEmp;

    @GetMapping("/movimiento")
    public String listar(Model model){
        model.addAttribute("movimientos", servicioMovEmp.listarMovimiento());
        return ("frmMovimiento");
    }

    @GetMapping("movimiento/nuevo")
    public String frmregistro(Model model){
        model.addAttribute("movimientoinsertar", new movimientoDinero());
        return "agrMovimiento";
    }

    @PostMapping("movimiento/guardar")
    public String insertar(movimientoDinero movimientodinero) {
        servicioMovEmp.guardarMovimiento(movimientodinero);
        return "redirect:/movimiento";
    }


    @GetMapping("movimiento/actualizar/{id}")
    public String frmActualizar(@PathVariable ("id") Integer id, Model model) {
        movimientoDinero movimientodinero = servicioMovEmp.consultarMovimiento(id);
        model.addAttribute("movimientoactualizar", movimientodinero);
        return "actMovimiento";
    }

    @PostMapping("movimiento/actualizar")
    public String actualizar(movimientoDinero movimientodinero){
        servicioMovEmp.guardarMovimiento(movimientodinero);
        return "redirect:/movimiento";
    }

    @GetMapping("movimiento/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id){
        servicioMovEmp.eliminarMovimiento(id);
        return ("redirect:/movimiento");
    }




    /*@GetMapping("/movimiento")
    public List<movimientoDinero> listar(){
        return servicioMovEmp.listarMovimiento();
    }

    @GetMapping("/movimiento/{id}")
    public movimientoDinero buscarPorId(@PathVariable("id")Integer id){
        return servicioMovEmp.consultarMovimiento(id);
    }

    @PostMapping("/movimiento")
    public movimientoDinero insertar(@RequestBody movimientoDinero movimientoDinero){
        return servicioMovEmp.guardarMovimiento(movimientoDinero);
    }

    @DeleteMapping("/movimiento/{id}")
    public void eliminar(@PathVariable ("id") Integer codigoMovimiento){
        servicioMovEmp.eliminarMovimiento(codigoMovimiento);
    }

    @PatchMapping("/movimiento/{id}")
    public movimientoDinero actualizarMovimientoId(@PathVariable("id") Integer codigoMovimiento, @RequestBody Map<Object, Object> objectMap){
        return servicioMovEmp.actualizarMovimientoId(codigoMovimiento, objectMap);
    }

    @PutMapping("/movimiento")
    public movimientoDinero actualizarMovimiento(@RequestBody movimientoDinero movimientodinero){
        return servicioMovEmp.actualizarMovimiento(movimientodinero);
    }

    @GetMapping("/empresa/{id}/movimiento")
    public List<movimientoDinero> getAllmovimientoDineroPorempresa(Integer id){
        return this.servicioMovEmp.findmovimientoDineroByempresa(id);
    }

     */

}
