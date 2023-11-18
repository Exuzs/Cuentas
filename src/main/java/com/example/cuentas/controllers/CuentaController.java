package com.example.cuentas.controllers;

import com.example.cuentas.entities.Cuenta;
import com.example.cuentas.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> obtenerCuentas() {
        List<Cuenta> cuentas = cuentaService.obtenerTodasLasCuentas();
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerCuentaPorId(@PathVariable Long id) {
        Cuenta cuenta = cuentaService.obtenerCuentaPorId(id);
        return ResponseEntity.ok(cuenta);
    }

    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        Cuenta nuevaCuenta = cuentaService.crearCuenta(cuenta);
        return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        Cuenta cuentaActualizada = cuentaService.actualizarCuenta(id, cuenta);
        return ResponseEntity.ok(cuentaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }
}


