package com.example.cuentas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;

    private String nombreCuenta;

    @ManyToOne
    @JoinColumn(name = "idTipoCuenta")
    private TipoCuenta tipoCuenta;

    private BigDecimal saldo;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Cuenta() {
    }

    public Cuenta(String nombreCuenta, TipoCuenta tipoCuenta, BigDecimal saldo, String descripcion, Usuario usuario) {
        this.nombreCuenta = nombreCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

