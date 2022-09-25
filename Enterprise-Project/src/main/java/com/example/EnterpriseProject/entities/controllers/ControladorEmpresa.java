package com.example.EnterpriseProject.entities.controllers;

import com.example.EnterpriseProject.entities.Empleado;
import com.example.EnterpriseProject.entities.Empresa;
import com.example.EnterpriseProject.services.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;


@Controller
public class ControladorEmpresa {

    @Autowired
    private ServicioEmpresa serEmpr;


    @GetMapping("/empresa")
    public String listar(Model model){
        model.addAttribute("empresas",serEmpr.listarEmpresa());
        return ("frmempresa");
    }

    @GetMapping("empresa/nuevo")
    public String frmregistro(Model model){
        model.addAttribute("empresainsertar", new Empresa());
        return "agrEmpresa";
    }

    @PostMapping("empresa/guardar")
    public String insertar(Empresa empresa) {
        serEmpr.guardarEmpresa(empresa);
        return "redirect:/empresa";
    }


    @GetMapping("empresa/actualizar/{id}")
    public String frmActualizar(@PathVariable ("id") Integer id, Model model) {
        Empresa empresa = serEmpr.consultarEmpresa(id);
        model.addAttribute("empresaactualizar", empresa);
        return "actEmpresa";
    }

    @PostMapping("empresa/actualizar")
    public String actualizar(Empresa empresa){
        serEmpr.guardarEmpresa(empresa);
        return "redirect:/empresa";
    }

    @GetMapping("empresa/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id){
        serEmpr.eliminarEmpresa(id);
        return ("redirect:/empresa");
    }


    /*@GetMapping("/empresa")
    public List<Empresa> listar(){
        return serEmpr.listarEmpresa();
    }

    @GetMapping("/empresa/{id}")
    public Empresa buscarPorId(@PathVariable ("id")Integer nit){
        return serEmpr.consultarEmpresa(nit);
    }

    @PostMapping("/empresa")
    public Empresa insertar(@RequestBody Empresa empresa){
        return serEmpr.guardarEmpresa(empresa);
    }

    @PutMapping("/empresa")
    public Empresa actualizar(@RequestBody Empresa empresa){
        return serEmpr.actualizarEmpresa(empresa);
    }

    @DeleteMapping("/empresa/{id}")
    public void eliminar(@PathVariable("id") Integer nit){
        serEmpr.eliminarEmpresa(nit);
    }

    @PatchMapping("/empresa/{id}")
    public Empresa actualizarPorId(@PathVariable("id") Integer nit, @RequestBody Map<Object, Object> objectMap){
        return serEmpr.actualizarPorId(nit, objectMap);
    }

     */
}


