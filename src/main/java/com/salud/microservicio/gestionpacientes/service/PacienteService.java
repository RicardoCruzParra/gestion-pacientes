package com.salud.microservicio.gestionpacientes.service;

import com.salud.microservicio.gestionpacientes.exception.PacienteNoEncontradoException;
import com.salud.microservicio.gestionpacientes.model.Paciente;
import com.salud.microservicio.gestionpacientes.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente crearPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNoEncontradoException("Paciente con ID " + id + " no encontrado"));
    }

    public Paciente actualizarDiagnostico(Long id, String nuevoDiagnostico) {
        Paciente paciente = obtenerPacientePorId(id);
        paciente.setDiagnostico(nuevoDiagnostico);
        return pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Long id) {
        Paciente paciente = obtenerPacientePorId(id);
        pacienteRepository.delete(paciente);
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }
}
