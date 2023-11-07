package org.lysmmorklair.api.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleados")
public class Empleado {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "posicion")
    private String posicion;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "empleado",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<EmpleadoHabilidad> habilidades;


    // define constructors
    public Empleado() {}

    public Empleado(int id, String nombre, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public Empleado(String nombre, String posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public List<EmpleadoHabilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<EmpleadoHabilidad> habilidades) {
        this.habilidades = habilidades;
    }


    // add a convenience method

    public void addHabilidad(EmpleadoHabilidad habilidad) {
        if (habilidades == null) {
            habilidades = new ArrayList<>();
        }
        habilidades.add(habilidad);
    }

    // define toString

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}
