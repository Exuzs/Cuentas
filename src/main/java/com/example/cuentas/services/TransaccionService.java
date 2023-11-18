package com.example.cuentas.services;

import com.example.cuentas.entities.Transaccion;
import com.example.cuentas.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransaccionService {
    @Autowired
    private TransaccionRepository transaccionRepository;

    public List<Transaccion> obtenerTodasLasTransacciones() {
        return transaccionRepository.findAll();
    }

    public Transaccion obtenerTransaccionPorId(Long idTransaccion) {
        return transaccionRepository.findById(idTransaccion)
                .orElseThrow(() -> new NoSuchElementException("Transacción no encontrada"));
    }

    public Transaccion crearTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public Transaccion actualizarTransaccion(Long idTransaccion, Transaccion transaccion) {
        if (transaccionRepository.existsById(idTransaccion)) {
            transaccion.setIdTransaccion(idTransaccion);
            return transaccionRepository.save(transaccion);
        } else {
            throw new NoSuchElementException("Transacción no encontrada");
        }
    }

    public void eliminarTransaccion(Long idTransaccion) {
        if (transaccionRepository.existsById(idTransaccion)) {
            transaccionRepository.deleteById(idTransaccion);
        } else {
            throw new NoSuchElementException("Transacción no encontrada");
        }
    }
}

