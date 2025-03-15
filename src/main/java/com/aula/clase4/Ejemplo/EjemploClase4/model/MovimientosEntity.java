package com.aula.clase4.Ejemplo.EjemploClase4.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="movimientos")
public class MovimientosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int id;
    @Column(length = 100)
    private String descripcion;
    private  String fecha;
    @Column(length = 12)
    private String archivo;
    @Column(length = 12)
    private String usuario;


}
