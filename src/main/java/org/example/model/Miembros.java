package org.example.model;

import java.time.LocalDate;

public class Miembros {
    private int miembro_id;
    private String nombre;
    private String apellido;
    private LocalDate fecha_inscripcion;

    public Miembros() {
    }

    public Miembros(int miembro_id, String nombre, String apellido, LocalDate fecha_inscripcion) {
        this.miembro_id = miembro_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public int getMiembro_id() {
        return miembro_id;
    }

    public void setMiembro_id(int miembro_id) {
        this.miembro_id = miembro_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    @Override
    public String toString() {
        return "Miembros{" +
                "miembro_id=" + miembro_id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_inscripcion=" + fecha_inscripcion +
                '}';
    }
}
