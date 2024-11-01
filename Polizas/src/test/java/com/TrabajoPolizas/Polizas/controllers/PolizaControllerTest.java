package com.TrabajoPolizas.Polizas.controllers;

import com.TrabajoPolizas.Polizas.Mocks.Mocks;
import com.TrabajoPolizas.Polizas.controller.PolizaController;
import com.TrabajoPolizas.Polizas.dtos.PolizaDTO;
import com.TrabajoPolizas.Polizas.exception.PolizaNotFoundException;
import com.TrabajoPolizas.Polizas.model.Poliza;
import com.TrabajoPolizas.Polizas.service.ClienteService;
import com.TrabajoPolizas.Polizas.service.PolizaService;
import com.TrabajoPolizas.Polizas.service.TipoSeguroService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PolizaControllerTest {

    @Mock
    private PolizaService polizaService;

    @Mock
    private ClienteService clienteService;

    @Mock
    private TipoSeguroService tipoSeguroService;

    @InjectMocks
    private PolizaController polizaController;

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
    void testGetAll(){
        System.out.println("Esta es la ejecucion de la Prueba Unitaria Get All");

        // Datos de prueba
        PolizaDTO poliza1 = Mocks.crearEmpleadoMockDto();
        PolizaDTO poliza2 = Mocks.crearEmpleadoMockDto();


        List<PolizaDTO> polizas = Arrays.asList(poliza1, poliza2);

        // Configurar el comportamiento del mock
        when(polizaService.listarTodosDto()).thenReturn(polizas);

        // Llamar al método del controlador
        ResponseEntity<List<PolizaDTO>> response = polizaController.getAll();

        // Verificar el resultado
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
    }
    @Test
    void testCrearPoliza(){
        // Datos de prueba
        Poliza poliza = Mocks.crearEmpleadoMock();

        // Convertir a Dto
        PolizaDTO responsePolizaDTO= new PolizaDTO();
        responsePolizaDTO.setId(poliza.getId());
        responsePolizaDTO.setNombreAsesor(poliza.getNombreAsesor());
        responsePolizaDTO.setMatricula(poliza.getMatricula());
        responsePolizaDTO.setObjetoAsegurado(poliza.getObjetoAsegurado());
        responsePolizaDTO.setTipoCambio(poliza.getTipoCambio());
        responsePolizaDTO.setFechaVencimiento(poliza.getFechaVencimiento());
        responsePolizaDTO.setDeBaja(poliza.getDeBaja());
        responsePolizaDTO.setClienteId(poliza.getPolizaConCliente().getId());
        responsePolizaDTO.setTipoSeguroId(poliza.getPolizaConTipo().getId());

        assertNotNull(responsePolizaDTO, "responsePolizaDTO es null");

        // Configurar el comportamiento del mock
        Mockito.when(polizaService.save(poliza)).thenReturn(poliza);
        // Llamar al metodo del controlador
        ResponseEntity<PolizaDTO> response = polizaController.crearPoliza(responsePolizaDTO);
        // Verificar el resultado
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(201), response.getStatusCode());
    }

    @Test
    void testBorrarPolizaEncontro() throws PolizaNotFoundException {
        // Datos de prueba
        Long nroPoliza = 1L;

        // Configurar el comportamiento del mock para lanzar una excepción
        doNothing().when(polizaService).deleteById(nroPoliza);
        // Llamar al metodo del controlador
        ResponseEntity<String> response = polizaController.borrarPoliza(nroPoliza);
        // Verificar el resultado
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());

    }

    @Test
    void testUpdatePoliza() throws PolizaNotFoundException{
        // Datos de prueba
        Poliza poliza = Mocks.crearEmpleadoMock();
        Long nroPoliza = poliza.getId();
        // Configurar el comportamiento del mock para lanzar una excepción
        when(polizaService.update(poliza,nroPoliza)).thenReturn(poliza);
        // Llamar al metodo del controlador
        ResponseEntity<Poliza> response = polizaController.updatePoliza(nroPoliza,poliza);
        // Verificar el resultado
        assertNotNull(response);
        assertEquals(poliza, response.getBody());
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
    }

}
