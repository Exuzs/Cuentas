package com.example.cuentas.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(unique = true)
    private String email;
    private String emailNormalizado;
    private String password;

    public Usuario() {
    }

    public Usuario(String email, String emailNormalizado, String password) {
        this.email = email;
        this.emailNormalizado = emailNormalizado;
        this.password = password;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailNormalizado() {
        return emailNormalizado;
    }

    public void setEmailNormalizado(String emailNormalizado) {
        this.emailNormalizado = emailNormalizado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

