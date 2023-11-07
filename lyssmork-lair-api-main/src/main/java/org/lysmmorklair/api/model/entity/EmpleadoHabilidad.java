package org.lysmmorklair.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "empleados_skills")
@AssociationOverrides({
        @AssociationOverride(name = "id.empleado",
                joinColumns = @JoinColumn(name = "empleado_id")),
        @AssociationOverride(name = "id.habilidad",
                joinColumns = @JoinColumn(name = "skill_id")) })
public class EmpleadoHabilidad {

    @EmbeddedId
    private EmpleadoHabilidadId id = new EmpleadoHabilidadId();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("empleadoId")
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;


    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("habilidadId")
    @JoinColumn(name = "skill_id")
    private Habilidad habilidad;

    @Column(name = "nivel")
    private int nivel;


    // define constructors
    public EmpleadoHabilidad() {}

    public EmpleadoHabilidad(Empleado empleado, Habilidad habilidad, int nivel) {
        this.empleado = empleado;
        this.habilidad = habilidad;
        this.nivel = nivel;
        this.id = new EmpleadoHabilidadId(empleado.getId(), habilidad.getId());
    }

    // define getter/setter

    public EmpleadoHabilidadId getId() {
        return id;
    }

    public void setId(EmpleadoHabilidadId id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
