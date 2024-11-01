package com.TrabajoPolizas.Polizas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre del cliente no debe estar vacia")
    private String nombre;

    @NotEmpty(message = "El apellido del cliente no debe estar vacia")
    private String apellido;

    @Email
    @NotEmpty(message = "El Email del cliente no debe estar vacia")
    private String email;

    @NotEmpty(message = "La nacionalidad del cliente no debe estar vacia")
    private String nacionalidad;

    @NotEmpty(message = "La dni del cliente no debe estar vacia")
    @Pattern(regexp="\\{a}\\d{7,8}", message = "El dni debe contener 7 u 8 digitos" )
    private String dni;

    @NotEmpty(message = "El telefono del cliente no debe estar vacia")
    private String telefono;

    @Column(name="fecha_nacimiento")
    @Past(message = "La fecha debe ser anterior a la actual")
    private LocalDateTime fechaNacimiento;

    @Column(name = "de_baja")
    @NotNull(message = "el estado no debe estar vacio")
    private Boolean deBaja;

    @OneToMany(mappedBy = "polizaConCliente")
    private List<Poliza> polizasAsignadas;

}
