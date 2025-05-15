package org.example.model;

import java.time.LocalDate;

public class Prestamos {
    private int prestamo_id;
    private int libro_id;
    private int miembro_id;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion;

    public Prestamos() {
    }

    public Prestamos(int prestamo_id, int libro_id, int miembro_id, LocalDate fecha_prestamo, LocalDate fecha_devolucion) {
        this.prestamo_id = prestamo_id;
        this.libro_id = libro_id;
        this.miembro_id = miembro_id;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getPrestamo_id() {
        return prestamo_id;
    }

    public void setPrestamo_id(int prestamo_id) {
        this.prestamo_id = prestamo_id;
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    public int getMiembro_id() {
        return miembro_id;
    }

    public void setMiembro_id(int miembro_id) {
        this.miembro_id = miembro_id;
    }

    public LocalDate getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(LocalDate fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    @Override
    public String toString() {
        return "Prestamos{" +
                "prestamo_id=" + prestamo_id +
                ", libro_id=" + libro_id +
                ", miembro_id=" + miembro_id +
                ", fecha_prestamo=" + fecha_prestamo +
                ", fecha_devolucion=" + fecha_devolucion +
                '}';
    }
}
