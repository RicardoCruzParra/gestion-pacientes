package com.salud.microservicio.gestionpacientes.exception;

import com.salud.microservicio.gestionpacientes.model.Paciente;
import com.salud.microservicio.gestionpacientes.repository.PacienteRepository;

public class PacienteNoEncontradoException extends RuntimeException {
    public PacienteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
