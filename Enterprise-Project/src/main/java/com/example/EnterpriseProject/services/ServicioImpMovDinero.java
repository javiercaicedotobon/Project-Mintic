package com.example.EnterpriseProject.services;

import com.example.EnterpriseProject.entities.movimientoDinero;
import com.example.EnterpriseProject.repositories.RepositorioMovDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ServicioImpMovDinero implements ServicioMovEmpleado {


    @Autowired
    private RepositorioMovDinero repositorioMovDinero;


    @Override
    public List<movimientoDinero> listarMovimiento() {
        return repositorioMovDinero.findAll();
    }

    @Override
    public movimientoDinero guardarMovimiento(movimientoDinero movimientodinero) {
        return repositorioMovDinero.save(movimientodinero);
    }

    @Override
    public movimientoDinero consultarMovimiento(Integer codigoMovimiento) {
        return repositorioMovDinero.findById(codigoMovimiento).get();
    }

    @Override
    public movimientoDinero actualizarMovimiento(movimientoDinero movimientodinero) {
        return repositorioMovDinero.save(movimientodinero);
    }

    @Override
    public void eliminarMovimiento(Integer codigoMovimiento) {
        repositorioMovDinero.deleteById(codigoMovimiento);
    }

    @Override
    public movimientoDinero actualizarMovimientoId(Integer codigoMovimiento, Map<Object,Object> objectMap) {
        movimientoDinero mve=repositorioMovDinero.findById(codigoMovimiento).get();
        objectMap.forEach((key,value)->{
            Field field= ReflectionUtils.findField(movimientoDinero.class,(String)key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,mve,value);
        });
        return repositorioMovDinero.save(mve);
    }

   @Override
    public List<movimientoDinero> getAllmovimientoDineroPorempresa(Integer nit) {
        return this.repositorioMovDinero.findmovimientoDineroByempresa(nit);
    }

    @Override
    public List<movimientoDinero> findmovimientoDineroByempresa(Integer id) {
        return repositorioMovDinero.findmovimientoDineroByempresa(id);
    }
}

