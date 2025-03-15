package com.aula.clase4.Ejemplo.EjemploClase4.service;

import com.aula.clase4.Ejemplo.EjemploClase4.dto.MovimientosDto;
import com.aula.clase4.Ejemplo.EjemploClase4.model.MovimientosEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMovimientosService {
    ResponseEntity<?> create(MovimientosDto movimientosDto);
    ResponseEntity<List<MovimientosEntity>> getAll();
    ResponseEntity<?> delete(int id);
    ResponseEntity<MovimientosEntity> findByID(int id);
    ResponseEntity<?> getByUser(String usuario);
    /*ResponseEntity<?> update(int id,UserDto userDto);*/
}
