package com.demo.Demomaker.model;

public class Empleado {

    private Long id;
    private String nombre;
    private int diasVacacionesDisponibles;

    public Empleado(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.diasVacacionesDisponibles = 15; // Empleado inicia con 15 días de vacaciones
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiasVacacionesDisponibles() {
        return diasVacacionesDisponibles;
    }

    public void setDiasVacacionesDisponibles(int diasVacacionesDisponibles) {
        this.diasVacacionesDisponibles = diasVacacionesDisponibles;
    }

    public void descontarDias(int dias) {
        this.diasVacacionesDisponibles -= dias;
    }
}