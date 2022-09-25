package com.example.EnterpriseProject.services;

import com.example.EnterpriseProject.entities.Empleado;

import java.util.List;
import java.util.Map;

public interface ServicioEmpleado {
    public List<Empleado> listarEmpleado();
    public Empleado guardarEmpleado(Empleado empleado);
    public Empleado consultarEmpleado(Integer cedula);
    public Empleado actualizarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Integer cedula);

    public Empleado actualizarPorId(Integer cedula, Map<Object, Object> objectMap);
}
