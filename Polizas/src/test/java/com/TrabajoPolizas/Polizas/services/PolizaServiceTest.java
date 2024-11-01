package com.TrabajoPolizas.Polizas.services;

import com.TrabajoPolizas.Polizas.Mocks.Mocks;
import com.TrabajoPolizas.Polizas.dtos.PolizaDTO;
import com.TrabajoPolizas.Polizas.exception.PolizaNotFoundException;
import com.TrabajoPolizas.Polizas.model.Poliza;
import com.TrabajoPolizas.Polizas.repository.PolizaRepository;
import com.TrabajoPolizas.Polizas.service.PolizaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PolizaServiceTest {

    @Mock
    private PolizaRepository polizaRepository;

    @InjectMocks
    private PolizaService polizaService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testlistarTodoDto(){
        System.out.println("Esta es la ejecucion de la Prueba Unitaria Servicio listarTodosDto");

        // Datos de prueba
        Poliza poliza1 = Mocks.crearEmpleadoMock();
        Poliza poliza2 = Mocks.crearEmpleadoMock();


        List<Poliza> polizas = Arrays.asList(poliza1, poliza2);

        // Configurar el comportamiento del mock
        when(polizaRepository.findAll()).thenReturn(polizas);

        // Llamar al metodo del servicio
        List<PolizaDTO> response = polizaService.listarTodosDto();
        // Verificar el resultado
        assertNotNull(response);
    }

    @Test
    void testDeleteById() throws PolizaNotFoundException{
        // Datos de prueba
        Long id = 1L;
        // Configurar el comportamiento del mock
        doNothing().when(polizaRepository).deleteById(id);
        polizaRepository.deleteById(1L);

        // Verificar el resultado
        verify(polizaRepository,times(1)).deleteById(1L);

    }

}
