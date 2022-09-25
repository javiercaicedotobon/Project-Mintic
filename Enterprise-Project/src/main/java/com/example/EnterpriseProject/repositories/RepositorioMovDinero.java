package com.example.EnterpriseProject.repositories;

import com.example.EnterpriseProject.entities.movimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioMovDinero extends JpaRepository<movimientoDinero, Integer> {
    @Query("SELECT t FROM movimientoDinero t WHERE t.empresas.nit= ?1")
    List<movimientoDinero> findmovimientoDineroByempresa(Integer id);
}
