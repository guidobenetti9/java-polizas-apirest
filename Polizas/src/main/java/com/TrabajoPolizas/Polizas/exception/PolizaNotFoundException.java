package com.TrabajoPolizas.Polizas.exception;

public class PolizaNotFoundException extends Exception{
    public PolizaNotFoundException(Long id){
        super("Poliza con id "+id+" no se encontró");
    }

}
