package com.example.cuentas.controllers;

import com.example.cuentas.entities.Cuenta;
import com.example.cuentas.entities.TipoCuenta;
import com.example.cuentas.services.CuentaService;
import com.example.cuentas.services.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-cuenta")
public class TipoCuentaController {
    @Autowired
    private TipoCuentaService tipoCuentaService;

    @GetMapping
    public ResponseEntity<List<TipoCuenta>> obtenerTiposCuenta() {
        List<TipoCuenta> tiposCuenta = tipoCuentaService.obtenerTodosLosTiposCuenta();
        return ResponseEntity.ok(tiposCuenta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCuenta> obtenerTipoCuentaPorId(@PathVariable Long id) {
        TipoCuenta tipoCuenta = tipoCuentaService.obtenerTipoCuentaPorId(id);
        return ResponseEntity.ok(tipoCuenta);
    }

    @PostMapping
    public ResponseEntity<TipoCuenta> crearTipoCuenta(@RequestBody TipoCuenta tipoCuenta) {
        TipoCuenta nuevoTipoCuenta = tipoCuentaService.crearTipoCuenta(tipoCuenta);
        return new ResponseEntity<>(nuevoTipoCuenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCuenta> actualizarTipoCuenta(@PathVariable Long id, @RequestBody TipoCuenta tipoCuenta) {
        TipoCuenta tipoCuentaActualizado = tipoCuentaService.actualizarTipoCuenta(id, tipoCuenta);
        return ResponseEntity.ok(tipoCuentaActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoCuenta(@PathVariable Long id) {
        tipoCuentaService.eliminarTipoCuenta(id);
        return ResponseEntity.noContent().build();
    }
}

