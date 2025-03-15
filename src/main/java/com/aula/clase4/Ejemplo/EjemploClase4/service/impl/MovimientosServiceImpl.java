package com.aula.clase4.Ejemplo.EjemploClase4.service.impl;

import com.aula.clase4.Ejemplo.EjemploClase4.dto.MovimientosDto;
import com.aula.clase4.Ejemplo.EjemploClase4.model.MovimientosEntity;
import com.aula.clase4.Ejemplo.EjemploClase4.repository.IMovimientosRepository;
import com.aula.clase4.Ejemplo.EjemploClase4.service.IMovimientosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovimientosServiceImpl implements IMovimientosService {
    private  final IMovimientosRepository iMovimientosRepository;

    @Override
    public ResponseEntity<?> create(MovimientosDto movimientosDto) {
        MovimientosEntity movimiento = new MovimientosEntity();
        movimiento.setDescripcion(movimientosDto.getDescripcion());
        movimiento.setFecha(movimientosDto.getFecha());
        movimiento.setArchivo(movimientosDto.getArchivo());
        movimiento.setUsuario(movimientosDto.getUsuario());
        MovimientosEntity movimientoNuevo= this.iMovimientosRepository.save(movimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoNuevo);

    }

    @Override
    public ResponseEntity<List<MovimientosEntity>> getAll() {
        return  ResponseEntity.ok(this.iMovimientosRepository.findAll());
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Optional  <MovimientosEntity> movimientos= this.iMovimientosRepository.findById(id);
        if(movimientos.isPresent()){
            this.iMovimientosRepository.deleteById(id);
            return ResponseEntity.ok().body("movimiento ha sido eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movimiento no encontrado");
    }

    @Override
    public ResponseEntity<MovimientosEntity> findByID(int id) {
        Optional<MovimientosEntity> movimientos=this.iMovimientosRepository.findById(id);
        if(movimientos.isPresent()){
            return ResponseEntity.ok(movimientos.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }



    @Override
    public ResponseEntity<?> getByUser(String usuario) {
        Optional<MovimientosEntity> movimientos=this.iMovimientosRepository.findByUsuario(usuario);
        if(movimientos.isPresent()){
            return ResponseEntity.ok(movimientos);

        }
        return ResponseEntity.ok(new MovimientosEntity());
    }
}
