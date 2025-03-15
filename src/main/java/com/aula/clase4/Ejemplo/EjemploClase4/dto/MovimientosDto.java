package com.aula.clase4.Ejemplo.EjemploClase4.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientosDto {

    // todo el nombre no debe tener numeros
    @NotBlank
    @Size(min=1,max=100,message = "descripción del movimiento no puede ser mayor a 100 caracteres")
    private String descripcion;
    @NotBlank
    private  String fecha;
    @NotBlank
    private String archivo;
    @NotBlank
    private String usuario;

}
