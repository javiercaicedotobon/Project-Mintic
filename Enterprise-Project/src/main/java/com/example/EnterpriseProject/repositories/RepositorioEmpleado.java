package com.example.EnterpriseProject.repositories;

import com.example.EnterpriseProject.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Integer> {


}
