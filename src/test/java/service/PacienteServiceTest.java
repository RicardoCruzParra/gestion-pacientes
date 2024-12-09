package service;

import com.salud.microservicio.gestionpacientes.model.Paciente;
import com.salud.microservicio.gestionpacientes.repository.PacienteRepository;
import com.salud.microservicio.gestionpacientes.service.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;

    @Mock
    private PacienteRepository pacienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerPacientePorId() {
        // Datos de prueba
        Paciente mockPaciente = new Paciente(1L, "Juan", "Perez", 30, "2024-12-01", "Gripe");
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(mockPaciente));

        // Acción
        Paciente paciente = pacienteService.obtenerPacientePorId(1L);

        // Verificación
        assertNotNull(paciente);
        assertEquals("Juan", paciente.getNombre());
        assertEquals("Perez", paciente.getApellido());
        verify(pacienteRepository, times(1)).findById(1L);
    }

    @Test
    void testActualizarDiagnostico() {
        // Datos de prueba
        Paciente mockPaciente = new Paciente(1L, "Maria", "Gomez", 40, "2024-11-01", "Resfriado");
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(mockPaciente));
        when(pacienteRepository.save(mockPaciente)).thenReturn(mockPaciente);

        // Acción
        Paciente actualizado = pacienteService.actualizarDiagnostico(1L, "Bronquitis");

        // Verificación
        assertNotNull(actualizado);
        assertEquals("Bronquitis", actualizado.getDiagnostico());
        verify(pacienteRepository, times(1)).save(mockPaciente);
    }
}

