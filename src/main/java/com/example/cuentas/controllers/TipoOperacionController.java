package com.example.cuentas.controllers;

import com.example.cuentas.entities.TipoOperacion;
import com.example.cuentas.services.TipoOperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-operacion")
public class TipoOperacionController {
    @Autowired
    private TipoOperacionService tipoOperacionService;

    @GetMapping
    public ResponseEntity<List<TipoOperacion>> obtenerTiposOperacion() {
        List<TipoOperacion> tiposOperacion = tipoOperacionService.obtenerTodosLosTiposOperacion();
        return ResponseEntity.ok(tiposOperacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoOperacion> obtenerTipoOperacionPorId(@PathVariable Long id) {
        TipoOperacion tipoOperacion = tipoOperacionService.obtenerTipoOperacionPorId(id);
        return ResponseEntity.ok(tipoOperacion);
    }

    @PostMapping
    public ResponseEntity<TipoOperacion> crearTipoOperacion(@RequestBody TipoOperacion tipoOperacion) {
        TipoOperacion nuevoTipoOperacion = tipoOperacionService.crearTipoOperacion(tipoOperacion);
        return new ResponseEntity<>(nuevoTipoOperacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoOperacion> actualizarTipoOperacion(@PathVariable Long id, @RequestBody TipoOperacion tipoOperacion) {
        TipoOperacion tipoOperacionActualizado = tipoOperacionService.actualizarTipoOperacion(id, tipoOperacion);
        return ResponseEntity.ok(tipoOperacionActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoOperacion(@PathVariable Long id) {
        tipoOperacionService.eliminarTipoOperacion(id);
        return ResponseEntity.noContent().build();
    }
}
