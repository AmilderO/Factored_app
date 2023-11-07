package org.lysmmorklair.api.controller;


import org.lysmmorklair.api.model.entity.Empleado;
import org.lysmmorklair.api.service.EmpleadoService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService theEmpleadoService) {
        empleadoService = theEmpleadoService;
    }

    // add mapping for "/list"
    @GetMapping("/lista")
    public List<Empleado> listarEmpleados() {

        return empleadoService.findAll();
    }

    // mapear para obtener empleado por id

    @GetMapping("/lista/{id}")
    ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable int id) {

        Empleado empleado = empleadoService.findById(id);
        System.out.println(empleado);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(empleado);
    }
}
