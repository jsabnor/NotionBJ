package com.equipo2.NotionBJ.Services;

import com.equipo2.NotionBJ.Entities.Categoria;
import com.equipo2.NotionBJ.Repositories.CategoriaRepository;

import java.util.NoSuchElementException;

public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    // Constructor
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Method findAll
    public Iterable<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Method findById
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Categoria no encontrada"));
    }

    // Create new Categoria
    public Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Update Categoria
    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Delete Categoria by id
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    // Delete All Categorias
    public void deleteAll() {
        categoriaRepository.deleteAll();
    }

    // Exists Categoria by id
    public boolean existsById(Long id) {
        return categoriaRepository.existsById(id);
    }

    // Getter and Setter
    public CategoriaRepository getCategoriaRepository() {
        return categoriaRepository;
    }
}
