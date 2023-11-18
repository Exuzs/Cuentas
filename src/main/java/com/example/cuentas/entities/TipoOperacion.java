package com.example.cuentas.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TipoOperacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoOperacion;

    private String descripcion;

    public TipoOperacion() {
    }

    public TipoOperacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(Long idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


