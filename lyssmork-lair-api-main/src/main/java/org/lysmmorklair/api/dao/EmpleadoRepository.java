package org.lysmmorklair.api.dao;


import org.lysmmorklair.api.model.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    
}
