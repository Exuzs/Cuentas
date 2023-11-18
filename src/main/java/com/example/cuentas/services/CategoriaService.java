package com.example.cuentas.services;

import com.example.cuentas.entities.Categoria;
import com.example.cuentas.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria obtenerCategoriaPorId(Long idCategoria) {
        return categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new NoSuchElementException("Categoría no encontrada"));
    }

    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Long idCategoria, Categoria categoria) {
        if (categoriaRepository.existsById(idCategoria)) {
            categoria.setIdCategoria(idCategoria);
            return categoriaRepository.save(categoria);
        } else {
            throw new NoSuchElementException("Categoría no encontrada");
        }
    }

    public void eliminarCategoria(Long idCategoria) {
        if (categoriaRepository.existsById(idCategoria)) {
            categoriaRepository.deleteById(idCategoria);
        } else {
            throw new NoSuchElementException("Categoría no encontrada");
        }
    }
}
