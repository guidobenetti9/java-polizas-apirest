package com.TrabajoPolizas.Polizas.Mocks;

import com.TrabajoPolizas.Polizas.dtos.PolizaDTO;
import com.TrabajoPolizas.Polizas.model.Cliente;
import com.TrabajoPolizas.Polizas.model.Poliza;
import com.TrabajoPolizas.Polizas.model.TipoSeguro;

import java.time.LocalDateTime;
import java.util.Random;

public class Mocks {

    private static Long longRandom(final Long min, final Long max) {
        return new Random().nextLong(min, max);
    }


    public static PolizaDTO crearEmpleadoMockDto() {
        PolizaDTO poliza = new PolizaDTO();
        poliza.setId(longRandom(1L, 1000000L));
        poliza.setNombreAsesor("1");
        poliza.setMatricula("1");
        poliza.setDeBaja(false);
        poliza.setObjetoAsegurado("auto");
        poliza.setTipoCambio("ARS");
        poliza.setFechaVencimiento(null);
        poliza.setTipoSeguroId(1L);
        poliza.setClienteId(1L);
        return poliza;

    }
    public static Poliza crearEmpleadoMock() {

        Poliza poliza = new Poliza();
        poliza.setId(longRandom(1L, 1000000L));
        poliza.setNombreAsesor("Pedro");
        poliza.setMatricula("1");
        poliza.setDeBaja(false);
        poliza.setObjetoAsegurado("auto");
        poliza.setTipoCambio("ARS");
        poliza.setFechaVencimiento(null);

        TipoSeguro tipoSeguro=new TipoSeguro();
        tipoSeguro.setId(1L);
        tipoSeguro.setNombre("auto");
        tipoSeguro.setDeBaja(false);
        tipoSeguro.setCobertura("todo riesgo");
        poliza.setPolizaConTipo(tipoSeguro);

        Cliente cliente=new Cliente();
        cliente.setId(1L);
        cliente.setNombre("pepe");
        cliente.setApellido("carls");
        cliente.setEmail("pepon@gmail.gob");
        cliente.setDni("123456");
        cliente.setNacionalidad("arg");
        cliente.setFechaNacimiento(LocalDateTime.parse("2001-11-01T12:07:27.000"));
        cliente.setDeBaja(false);
        poliza.setPolizaConCliente(cliente);

        return poliza;

    }
}
