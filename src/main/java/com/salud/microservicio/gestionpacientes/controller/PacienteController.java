package com.salud.microservicio.gestionpacientes.controller;

import com.salud.microservicio.gestionpacientes.model.Paciente;
import com.salud.microservicio.gestionpacientes.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@Tag(name = "Pacientes", description = "Gestión de información de pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Crear un nuevo paciente")
    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@Valid @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.crearPaciente(paciente));
    }

    @Operation(summary = "Obtener un paciente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.obtenerPacientePorId(id));
    }

    @Operation(summary = "Actualizar el diagnóstico de un paciente")
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarDiagnostico(@PathVariable Long id, @RequestBody String diagnostico) {
        return ResponseEntity.ok(pacienteService.actualizarDiagnostico(id, diagnostico));
    }

    @Operation(summary = "Eliminar un paciente por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Obtener todos los pacientes")
    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodosLosPacientes() {
        return ResponseEntity.ok(pacienteService.obtenerTodosLosPacientes());
    }
}
