package com.demo.Demomaker.model;

import java.time.LocalDate;

public class Vacaciones {

    private Long id;
    private Empleado empleado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean aprobacion1;
    private boolean aprobacion2;

    public Vacaciones(Long id, Empleado empleado, LocalDate fechaInicio) {
        this.id = id;
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = calcularFechaFin(fechaInicio);
        this.aprobacion1 = false;
        this.aprobacion2 = false;
    }

    // Calcular fecha fin teniendo en cuenta 15 días hábiles de lunes a sábado
    private LocalDate calcularFechaFin(LocalDate fechaInicio) {
        LocalDate fechaFin = fechaInicio;
        int diasHabiles = 0;
        while (diasHabiles < 15) {
            fechaFin = fechaFin.plusDays(1);
            if (fechaFin.getDayOfWeek().getValue() <= 6) { // De lunes a sábado
                diasHabiles++;
            }
        }
        return fechaFin;
    }

    public boolean estaAprobada() {
        return aprobacion1 && aprobacion2;
    }

    public void aprobar1() {
        this.aprobacion1 = true;
    }

    public void aprobar2() {
        this.aprobacion2 = true;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}