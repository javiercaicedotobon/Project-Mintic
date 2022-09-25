package com.example.EnterpriseProject.entities.controllers;


import com.example.EnterpriseProject.entities.Empleado;
import com.example.EnterpriseProject.services.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class ControladorEmpleado {

    @Autowired
    private ServicioEmpleado serEmp;


    @GetMapping("/empleado")
    public String listar(Model model){
        model.addAttribute("empleados", serEmp.listarEmpleado());
        return ("frmempleados");
    }

    @GetMapping("empleado/nuevo")
    public String frmregistro(Model model){
        model.addAttribute("empleadoinsertar", new Empleado());
        return "agrEmpleado";
    }

    @PostMapping("empleado/guardar")
    public String insertar(Empleado empleado) {
        serEmp.guardarEmpleado(empleado);
        return "redirect:/empleado";
    }


    @GetMapping("empleado/actualizar/{id}")
    public String frmActualizar(@PathVariable ("id") Integer id, Model model) {
        Empleado empleado = serEmp.consultarEmpleado(id);
        model.addAttribute("empleadoactualizar", empleado);
        return "actEmpleado";
    }

    @PostMapping("empleado/actualizar")
    public String actualizar(Empleado empleado){
        serEmp.guardarEmpleado(empleado);
        return "redirect:/empleado";
    }

    @GetMapping("empleado/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id){
        serEmp.eliminarEmpleado(id);
        return ("redirect:/empleado");
    }

    /*@GetMapping("/empleado/{id}")
    public Empleado buscarPorId(@PathVariable("id")Integer id){
        return serEmp.consultarEmpleado(id);
    }


    @PostMapping("/empleado")
    public Empleado insertar(@RequestBody Empleado empleado){
        return serEmp.guardarEmpleado(empleado);
    }

    @PutMapping("/empleado")
    public Empleado actualizar(@RequestBody Empleado empleado){
        return serEmp.actualizarEmpleado(empleado);
    }

    @DeleteMapping("/empleado/{id}")
    public void eliminarpoId(@PathVariable("id") Integer id){
        serEmp.eliminarEmpleado(id);
    }

    @PatchMapping("/empleado/{id}")
    public Empleado actualizarPorId(@PathVariable("id") Integer id, @RequestBody Map<Object, Object> objectMap){
        return serEmp.actualizarPorId(id, objectMap);
    }

     */

}
