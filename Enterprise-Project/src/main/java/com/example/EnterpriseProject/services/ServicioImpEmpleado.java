package com.example.EnterpriseProject.services;

import com.example.EnterpriseProject.entities.Empleado;
import com.example.EnterpriseProject.repositories.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ServicioImpEmpleado implements ServicioEmpleado{

    @Autowired
    private RepositorioEmpleado repositorioEmpleado;

    @Override
    public List<Empleado> listarEmpleado() {
        return repositorioEmpleado.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return repositorioEmpleado.save(empleado);
    }

    @Override
    public Empleado consultarEmpleado(Integer cedula) {
        return repositorioEmpleado.findById(cedula).get();
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        return repositorioEmpleado.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Integer cedula) {
        repositorioEmpleado.deleteById(cedula);
    }

    @Override
    public Empleado actualizarPorId(Integer cedula, Map<Object, Object> objectMap) {
        Empleado empl=repositorioEmpleado.findById(cedula).get();
        objectMap.forEach((key, value) ->{
            Field field= ReflectionUtils.findField(Empleado.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, empl, value);
        });
        return repositorioEmpleado.save(empl);
    }
}
