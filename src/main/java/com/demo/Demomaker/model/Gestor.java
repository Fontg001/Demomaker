package com.demo.Demomaker.model;

public class Gestor {

    private Long id;
    private String nombre;

    public Gestor(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void aprobarVacaciones(Vacaciones vacaciones, int nivelAprobacion) {
        if (nivelAprobacion == 1) {
            vacaciones.aprobar1();
        } else if (nivelAprobacion == 2) {
            vacaciones.aprobar2();
        }
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
}


