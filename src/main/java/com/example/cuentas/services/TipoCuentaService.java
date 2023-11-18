package com.example.cuentas.services;

import com.example.cuentas.entities.TipoCuenta;
import com.example.cuentas.repositories.TipoCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TipoCuentaService {
    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;

    public List<TipoCuenta> obtenerTodosLosTiposCuenta() {
        return tipoCuentaRepository.findAll();
    }

    public TipoCuenta obtenerTipoCuentaPorId(Long idTipoCuenta) {
        return tipoCuentaRepository.findById(idTipoCuenta)
                .orElseThrow(() -> new NoSuchElementException("Tipo de cuenta no encontrado"));
    }

    public TipoCuenta crearTipoCuenta(TipoCuenta tipoCuenta) {
        return tipoCuentaRepository.save(tipoCuenta);
    }

    public TipoCuenta actualizarTipoCuenta(Long idTipoCuenta, TipoCuenta tipoCuenta) {
        if (tipoCuentaRepository.existsById(idTipoCuenta)) {
            tipoCuenta.setIdTipoCuenta(idTipoCuenta);
            return tipoCuentaRepository.save(tipoCuenta);
        } else {
            throw new NoSuchElementException("Tipo de cuenta no encontrado");
        }
    }

    public void eliminarTipoCuenta(Long idTipoCuenta) {
        if (tipoCuentaRepository.existsById(idTipoCuenta)) {
            tipoCuentaRepository.deleteById(idTipoCuenta);
        } else {
            throw new NoSuchElementException("Tipo de cuenta no encontrado");
        }
    }
}
