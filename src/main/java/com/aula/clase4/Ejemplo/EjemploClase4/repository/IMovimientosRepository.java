package com.aula.clase4.Ejemplo.EjemploClase4.repository;

import com.aula.clase4.Ejemplo.EjemploClase4.model.MovimientosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMovimientosRepository extends JpaRepository<MovimientosEntity,Integer> {
    Optional<MovimientosEntity> findByUsuario(String usuario);

}
