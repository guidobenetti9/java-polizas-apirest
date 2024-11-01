package com.TrabajoPolizas.Polizas.dtos;

import com.TrabajoPolizas.Polizas.model.Poliza;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PolizaDTO {
    private Long id;
    private String nombreAsesor;
    private String matricula;
    private String objetoAsegurado;
    private String tipoCambio;
    private Date fechaVencimiento;
    private Boolean deBaja;
    private Long clienteId;
    private Long tipoSeguroId;
}
