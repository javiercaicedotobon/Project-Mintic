package com.example.EnterpriseProject.repositories;

import com.example.EnterpriseProject.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa, Integer> {
}
