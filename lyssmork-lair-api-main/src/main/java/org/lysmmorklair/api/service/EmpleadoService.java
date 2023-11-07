package org.lysmmorklair.api.service;



import org.lysmmorklair.api.model.entity.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> findAll();

    Empleado findById(int id);
}
