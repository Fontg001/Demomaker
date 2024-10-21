package com.demo.Demomaker.controller;

import ch.qos.logback.core.model.Model;
import com.demo.Demomaker.model.Empleado;
import com.demo.Demomaker.model.Gestor;
import com.demo.Demomaker.model.Vacaciones;
import com.demo.Demomaker.service.VacacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/vacaciones")
public class VacacionesController {

    @Autowired
    private VacacionesService vacacionesService;

    @PostMapping("/solicitar")
    public Vacaciones solicitarVacaciones(@RequestParam Long empleadoId, @RequestParam String nombre, @RequestParam String fechaInicio) {
        Empleado empleado = new Empleado(empleadoId, nombre);
        LocalDate inicio = LocalDate.parse(fechaInicio);
        return vacacionesService.solicitarVacaciones(empleado, inicio);
    }

    @PostMapping("/aprobar")
    public String aprobarVacaciones(@RequestParam Long gestorId, @RequestParam String nombreGestor, @RequestParam Long vacacionesId, @RequestParam int nivelAprobacion) {
        Gestor gestor = new Gestor(gestorId, nombreGestor);
        vacacionesService.aprobarVacaciones(gestor, vacacionesId, nivelAprobacion);
        return "Aprobación nivel " + nivelAprobacion + " realizada por " + nombreGestor;
    }

    @GetMapping("/ver/{id}")
    public Vacaciones verVacaciones(@PathVariable Long id) {
        return vacacionesService.obtenerVacacionesPorId(id);
    }

    @Controller
    public class VacacionesViewController {

        @GetMapping("/vacaciones/solicitud")
        public String mostrarSolicitudVacacionesForm(Model model) {
            return "solicitudVacaciones";  // Renderiza la página solicitudVacaciones.html
        }

        @GetMapping("/vacaciones/aprobar")
        public String mostrarAprobacionVacacionesForm(Model model) {
            return "aprobarVacaciones";  // Renderiza la página aprobarVacaciones.html
        }
    }
}
