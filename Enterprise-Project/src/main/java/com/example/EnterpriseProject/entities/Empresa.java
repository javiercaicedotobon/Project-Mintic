package com.example.EnterpriseProject.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    private int nit;
    @Column(nullable = false, length = 40, unique = true)
    private String nombre;
    @Column(nullable = false, length = 30, unique = true)
    private String direccion;
    @Column(nullable = false, length = 15)
    private String telefono;

    @OneToMany(mappedBy = "empresas", cascade = CascadeType.ALL)
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "empresas", cascade = CascadeType.ALL)
    private List<movimientoDinero> movimientodinero;

    public Empresa(int nit, String nombre, String direccion, String telefono, List<Empleado> empleados, List<movimientoDinero> movimientodinero) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.empleados = empleados;
        this.movimientodinero = movimientodinero;
    }

    public Empresa() {
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<movimientoDinero> getMovimientodinero() {
        return movimientodinero;
    }

    public void setMovimientodinero(List<movimientoDinero> movimientodinero) {
        this.movimientodinero = movimientodinero;
    }
}
