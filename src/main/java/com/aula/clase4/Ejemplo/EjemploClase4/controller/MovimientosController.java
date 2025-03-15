package com.aula.clase4.Ejemplo.EjemploClase4.controller;

import com.aula.clase4.Ejemplo.EjemploClase4.controller.docs.IMovimientosController;
import com.aula.clase4.Ejemplo.EjemploClase4.dto.MovimientosDto;
import com.aula.clase4.Ejemplo.EjemploClase4.service.IMovimientosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class MovimientosController implements IMovimientosController {
    private final IMovimientosService movimientosService;

    @Override
    public ResponseEntity<?> create(MovimientosDto movimientosDto) {
        return this.movimientosService.create(movimientosDto);
    }

    @Override
    public ResponseEntity<?> getByUser(String usuario) {
        return this.movimientosService.getByUser(usuario);
    }

    @Override
    public ResponseEntity<?> delete(int idMovimiento) {
        return this.movimientosService.delete(idMovimiento);

    }

    @Override
    public ResponseEntity<?> getAll() {
        return this.movimientosService.getAll();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleExceptionArgument(MethodArgumentNotValidException ex){
        List<String> errorList = new ArrayList<>();
        for(FieldError error: ex.getBindingResult().getFieldErrors()){
            errorList.add(error.getObjectName()+":"+error.getField()+":"+error.getDefaultMessage());
            errorList.add(
                    """ 
                            Error del sistema %s:%s:%s """.formatted(error.getObjectName(),error.getField(),error.getDefaultMessage())
            );

        }
        errorList =ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(
                        error -> """
                                    Error del sistema %s:%s:%s ""\".formatted(error.getObjectName(),error.getField(),error.getDefaultMessage())
                                    """
                ).toList();
        return ResponseEntity.badRequest().body(errorList);
    }
}
