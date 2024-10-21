package com.demo.Demomaker.service;

import com.demo.Demomaker.model.Empleado;
import com.demo.Demomaker.model.Vacaciones;
import com.demo.Demomaker.model.Gestor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class VacacionesService {

    private Map<Long, Vacaciones> solicitudes = new HashMap<>();

    public Vacaciones solicitarVacaciones(@org.jetbrains.annotations.NotNull Empleado empleado, LocalDate fechaInicio) {
        if (empleado.getDiasVacacionesDisponibles() >= 15) {
            Vacaciones vacaciones = new Vacaciones((long) (solicitudes.size() + 1), empleado, fechaInicio);
            solicitudes.put(vacaciones.getId(), vacaciones);
            empleado.descontarDias(15);
            return vacaciones;
        }
        return null; // No tiene suficientes días disponibles
    }

    public Vacaciones obtenerVacacionesPorId(Long id) {
        return solicitudes.get(id);
    }

    public void aprobarVacaciones(@NotNull Gestor gestor, Long vacacionesId, int nivelAprobacion) {
        Vacaciones vacaciones = solicitudes.get(vacacionesId);
        gestor.aprobarVacaciones(vacaciones, nivelAprobacion);
    }
}
