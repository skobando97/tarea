package com.aula.clase4.Ejemplo.EjemploClase4.Exceptions;

import com.aula.clase4.Ejemplo.EjemploClase4.configs.ExceptionConfigs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
@AllArgsConstructor

public class HandleExceptions {
    private final ExceptionConfigs exceptionConfigs;
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> myHandleExceptionMethod(Exception e){
        var error="Error del sistema:" +e.getMessage();
        log.error(error);
        return ResponseEntity.badRequest().body(error);
    }
}
