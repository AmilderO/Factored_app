package org.lysmmorklair.api.service.imp;

import org.lysmmorklair.api.dao.EmpleadoRepository;
import org.lysmmorklair.api.model.entity.Empleado;
import org.lysmmorklair.api.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository theEmpleadoRepository) {
        empleadoRepository = theEmpleadoRepository;
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findById(int id) {
            return empleadoRepository.findById(id).orElse(null);
    }
}
