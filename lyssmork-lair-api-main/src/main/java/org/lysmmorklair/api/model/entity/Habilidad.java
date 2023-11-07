package org.lysmmorklair.api.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skills")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "habilidad",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<EmpleadoHabilidad> habilidades;


    // define constructors
    public Habilidad() {
    }

    public Habilidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Habilidad(String nombre) {
        this.nombre = nombre;
    }


    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EmpleadoHabilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<EmpleadoHabilidad> habilidades) {
        this.habilidades = habilidades;
    }


    // add a convenience method
    public void add(EmpleadoHabilidad tempEmpleadoHabilidad) {

        if (habilidades == null) {
            habilidades = new ArrayList<>();
        }

        habilidades.add(tempEmpleadoHabilidad);
    }
}
