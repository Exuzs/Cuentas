package com.example.cuentas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private LocalDateTime fechaTransaccion;
    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name = "idTipoOperacion")
    private TipoOperacion tipoOperacion;

    private String nota;

    @ManyToOne
    @JoinColumn(name = "idCuenta")
    private Cuenta cuenta;

    public Transaccion() {
    }

    public Transaccion(Usuario usuario, LocalDateTime fechaTransaccion, BigDecimal monto,
                       TipoOperacion tipoOperacion, String nota, Cuenta cuenta) {
        this.usuario = usuario;
        this.fechaTransaccion = fechaTransaccion;
        this.monto = monto;
        this.tipoOperacion = tipoOperacion;
        this.nota = nota;
        this.cuenta = cuenta;
    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}


