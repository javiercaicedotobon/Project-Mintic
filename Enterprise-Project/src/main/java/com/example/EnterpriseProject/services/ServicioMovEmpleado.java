package com.example.EnterpriseProject.services;

import com.example.EnterpriseProject.entities.movimientoDinero;

import java.util.List;
import java.util.Map;

public interface ServicioMovEmpleado {

    public List<movimientoDinero> listarMovimiento();
    public movimientoDinero guardarMovimiento(movimientoDinero movimientodinero);
    public movimientoDinero consultarMovimiento(Integer codigoMovimiento);
    public movimientoDinero actualizarMovimiento(movimientoDinero movimientodinero);
    public void eliminarMovimiento(Integer codigoMovimiento);

    public movimientoDinero actualizarMovimientoId(Integer codigoMovimiento, Map<Object, Object> objectMap);

    public List<movimientoDinero> getAllmovimientoDineroPorempresa(Integer nit);

    List<movimientoDinero> findmovimientoDineroByempresa(Integer id);
}
