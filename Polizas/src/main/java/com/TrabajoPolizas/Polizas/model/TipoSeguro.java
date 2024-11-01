package com.TrabajoPolizas.Polizas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tipos_seguros")
public class TipoSeguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre del tipo no debe estar vacio")
    private String nombre;

    @NotEmpty(message = "La cobertura no debe estar vacia")
    private String Cobertura;

    //@Min(value=10000, message = "El importe del tipo de poliza debe ser mayor que cero")
    //@Digits(integer = 7, fraction = 2, message = "Debe tener 2 decimales")
    //private double monto;

    @Column(name = "de_baja")
    @NotNull(message = "el estado no debe estar vacio")
    private Boolean deBaja;

    @OneToMany(mappedBy = "polizaConTipo")
    private List<Poliza> tiposAsignados;

}
