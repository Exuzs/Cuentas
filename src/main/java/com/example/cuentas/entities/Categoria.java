package com.example.cuentas.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String nombreCategoria;

    @ManyToOne
    @JoinColumn(name = "idTipoOperacion")
    private TipoOperacion tipoOperacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Categoria() {
    }

    public Categoria(String nombreCategoria, TipoOperacion tipoOperacion, Usuario usuario) {
        this.nombreCategoria = nombreCategoria;
        this.tipoOperacion = tipoOperacion;
        this.usuario = usuario;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

