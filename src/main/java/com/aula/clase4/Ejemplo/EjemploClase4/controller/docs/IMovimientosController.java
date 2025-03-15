package com.aula.clase4.Ejemplo.EjemploClase4.controller.docs;

import com.aula.clase4.Ejemplo.EjemploClase4.dto.MovimientosDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="movimientos-api",description="admin de movimiento")
@RequestMapping("/administrador/movimientos")
public interface IMovimientosController {
    @Operation(summary="ingresar un movimiento")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Movimiento ingresado satisfactoriamente"),
                    @ApiResponse(responseCode = "500",description = "Error de programación por favor contacte a su equipo de desarrollo"),
                    @ApiResponse(responseCode = "404",description = "Endpoint no encontrado")

            }
    )
    @PostMapping
    ResponseEntity<?> create (@RequestBody @Valid MovimientosDto movimientosDto);
    @Operation (summary = "Buscar movimientos del usuario")
    @ApiResponses(
            value={
                    @ApiResponse(responseCode = "200",description = "Movimientos del usuario"),
                    @ApiResponse(responseCode = "500",description = "Error de programación por favor contacte a su equipo de desarrollo"),
                    @ApiResponse(responseCode = "404",description = "Endpoint no encontrado")
            }
    )
    @GetMapping("/porUsuario")
    ResponseEntity<?> getByUser(@RequestParam("usuario") String usuario);
    @DeleteMapping("/eliminar")
    ResponseEntity<?> delete(@RequestParam("id") int idMovimiento);
    @GetMapping("/")
    ResponseEntity<?> getAll();

}
