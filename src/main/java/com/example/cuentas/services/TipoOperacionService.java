package com.example.cuentas.services;

import com.example.cuentas.entities.TipoOperacion;
import com.example.cuentas.repositories.TipoOperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TipoOperacionService {
    @Autowired
    private TipoOperacionRepository tipoOperacionRepository;

    public List<TipoOperacion> obtenerTodosLosTiposOperacion() {
        return tipoOperacionRepository.findAll();
    }

    public TipoOperacion obtenerTipoOperacionPorId(Long idTipoOperacion) {
        return tipoOperacionRepository.findById(idTipoOperacion)
                .orElseThrow(() -> new NoSuchElementException("Tipo de operación no encontrado"));
    }

    public TipoOperacion crearTipoOperacion(TipoOperacion tipoOperacion) {
        return tipoOperacionRepository.save(tipoOperacion);
    }

    public TipoOperacion actualizarTipoOperacion(Long idTipoOperacion, TipoOperacion tipoOperacion) {
        if (tipoOperacionRepository.existsById(idTipoOperacion)) {
            tipoOperacion.setIdTipoOperacion(idTipoOperacion);
            return tipoOperacionRepository.save(tipoOperacion);
        } else {
            throw new NoSuchElementException("Tipo de operación no encontrado");
        }
    }

    public void eliminarTipoOperacion(Long idTipoOperacion) {
        if (tipoOperacionRepository.existsById(idTipoOperacion)) {
            tipoOperacionRepository.deleteById(idTipoOperacion);
        } else {
            throw new NoSuchElementException("Tipo de operación no encontrado");
        }
    }
}

