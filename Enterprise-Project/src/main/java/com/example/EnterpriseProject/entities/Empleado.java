package com.example.EnterpriseProject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table (name = "empleados")
public class Empleado {
    @Id
    private int cedula;
    @Column(nullable = false, length = 40)
    private String nombre;
    @Column(nullable = false, length = 40, unique = true)
    private String correo;
    @Column(nullable = false, length = 40)
    private String rol;

    @OneToMany(mappedBy = "empleados", cascade = CascadeType.ALL)
    private List<movimientoDinero> movimientodineros;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name = "nit_empresa")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Empresa empresas;

    public Empleado(int cedula, String nombre, String correo, String rol, List<movimientoDinero> movimientodineros, Empresa empresas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.movimientodineros = movimientodineros;
        this.empresas = empresas;
    }

    public Empleado() {
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<movimientoDinero> getMovimientodineros() {
        return movimientodineros;
    }

    public void setMovimientodineros(List<movimientoDinero> movimientodineros) {
        this.movimientodineros = movimientodineros;
    }

    public Empresa getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresa empresas) {
        this.empresas = empresas;
    }
}
