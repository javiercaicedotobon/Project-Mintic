package com.example.EnterpriseProject.services;

import com.example.EnterpriseProject.entities.Empresa;

import java.util.List;
import java.util.Map;

public interface ServicioEmpresa {
    public List<Empresa> listarEmpresa();
    public Empresa guardarEmpresa(Empresa empresa);
    public Empresa consultarEmpresa(Integer nit);
    public Empresa actualizarEmpresa(Empresa empresa);
    public void eliminarEmpresa(Integer nit);

    public Empresa actualizarPorId (Integer nit, Map<Object, Object>objectMap);

}
