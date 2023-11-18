package com.example.cuentas.services;

import com.example.cuentas.entities.Usuario;
import com.example.cuentas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Long idUsuario, Usuario usuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuario.setIdUsuario(idUsuario);
            return usuarioRepository.save(usuario);
        } else {
            throw new NoSuchElementException("Usuario no encontrado");
        }
    }

    public void eliminarUsuario(Long idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuarioRepository.deleteById(idUsuario);
        } else {
            throw new NoSuchElementException("Usuario no encontrado");
        }
    }
}

