package com.example.cuentas.controllers;

import com.example.cuentas.entities.Transaccion;
import com.example.cuentas.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @GetMapping
    public ResponseEntity<List<Transaccion>> obtenerTransacciones() {
        List<Transaccion> transacciones = transaccionService.obtenerTodasLasTransacciones();
        return ResponseEntity.ok(transacciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> obtenerTransaccionPorId(@PathVariable Long id) {
        Transaccion transaccion = transaccionService.obtenerTransaccionPorId(id);
        return ResponseEntity.ok(transaccion);
    }

    @PostMapping
    public ResponseEntity<Transaccion> crearTransaccion(@RequestBody Transaccion transaccion) {
        Transaccion nuevaTransaccion = transaccionService.crearTransaccion(transaccion);
        return new ResponseEntity<>(nuevaTransaccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> actualizarTransaccion(@PathVariable Long id, @RequestBody Transaccion transaccion) {
        Transaccion transaccionActualizada = transaccionService.actualizarTransaccion(id, transaccion);
        return ResponseEntity.ok(transaccionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransaccion(@PathVariable Long id) {
        transaccionService.eliminarTransaccion(id);
        return ResponseEntity.noContent().build();
    }
}


