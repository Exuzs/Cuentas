package com.example.cuentas.entities;

import jakarta.persistence.*;

@Entity
public class TipoCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoCuenta;

    private String nombreTipoCuenta;


    public TipoCuenta() {
    }

    public TipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public Long getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(Long idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }
}

