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
@Table(name = "movimientos_de_dinero")
public class movimientoDinero {

    @Id
    private int codigoMovimiento;
    @Column(nullable = false, length = 40)
    private int movimientoMonto ;

    @Column(nullable = false, length = 30)
    private String conceptoMovimiento;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name= "id_empleados" )
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Empleado empleados;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name= "nit_empresa" )
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Empresa empresas;

    public movimientoDinero(int codigoMovimiento, int movimientoMonto, String conceptoMovimiento, Empleado empleados, Empresa empresas) {
        this.codigoMovimiento = codigoMovimiento;
        this.movimientoMonto = movimientoMonto;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleados = empleados;
        this.empresas = empresas;
    }

    public movimientoDinero() {
    }



    public int getCodigoMovimiento() {
        return codigoMovimiento;
    }

    public void setCodigoMovimiento(int codigoMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
    }

    public int getMovimientoMonto() {
        return movimientoMonto;
    }

    public void setMovimientoMonto(int movimientoMonto) {
        this.movimientoMonto = movimientoMonto;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado empleados) {
        this.empleados = empleados;
    }

    public Empresa getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresa empresas) {
        this.empresas = empresas;
    }
}
