package com.example.cuentas.services;

import com.example.cuentas.entities.Cuenta;
import com.example.cuentas.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> obtenerTodasLasCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta obtenerCuentaPorId(Long idCuenta) {
        return cuentaRepository.findById(idCuenta)
                .orElseThrow(() -> new NoSuchElementException("Cuenta no encontrada"));
    }

    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta actualizarCuenta(Long idCuenta, Cuenta cuenta) {
        if (cuentaRepository.existsById(idCuenta)) {
            cuenta.setIdCuenta(idCuenta);
            return cuentaRepository.save(cuenta);
        } else {
            throw new NoSuchElementException("Cuenta no encontrada");
        }
    }

    public void eliminarCuenta(Long idCuenta) {
        if (cuentaRepository.existsById(idCuenta)) {
            cuentaRepository.deleteById(idCuenta);
        } else {
            throw new NoSuchElementException("Cuenta no encontrada");
        }
    }
}

