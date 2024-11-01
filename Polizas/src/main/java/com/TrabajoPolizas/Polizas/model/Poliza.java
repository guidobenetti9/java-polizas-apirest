package com.TrabajoPolizas.Polizas.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "polizas")
public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_asesor")
    private String nombreAsesor;

    @NotEmpty(message = "La matricula no debe estar vacia")
    private String matricula;

    @Column(name = "objeto_asegurado")
    @NotEmpty(message = "el objeto asegurado no debe estar vacio")
    private String objetoAsegurado;

    @Column(name = "tipo_cambio")
    @NotEmpty(message = "el tipo de cambio no debe estar vacio")
    private String tipoCambio;

    @Column(name = "fecha_vencimiento")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fechaVencimiento;

    @Column(name = "de_baja")
    @NotNull(message = "el estado no debe estar vacio")
    private Boolean deBaja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente polizaConCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id")
    private TipoSeguro polizaConTipo;

}
