package org.lysmmorklair.api.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EmpleadoHabilidadId implements Serializable {

    @Column(name = "empleado_id")
    private int empleadoId;

    @Column(name = "skill_id")
    private int habilidadId;

    public EmpleadoHabilidadId() {}

    public EmpleadoHabilidadId(int empleadoId, int habilidadId) {
        this.empleadoId = empleadoId;
        this.habilidadId = habilidadId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public int getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(int habilidadId) {
        this.habilidadId = habilidadId;
    }
}
