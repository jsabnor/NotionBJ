package com.equipo2.NotionBJ.controllers;


import com.equipo2.NotionBJ.Entities.Categoria;
import com.equipo2.NotionBJ.Services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods= {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
})
public class CategoriaController {

    private CategoriaService categoriaService;

    // Constructor
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Metodos

    // Find all Categorias
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> findAllCategorias() {
        return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }

   // Find categoria by id
    @GetMapping("/categoria/{id}")
    public ResponseEntity <Categoria> mostrarPorId(Long id) {
        if(categoriaService.existCategoria(id)) {
            return new ResponseEntity<>(categoriaService.findById(id), HttpStatus.OK);
        }
        throw new RuntimeException("No existe la categoria");
    }


    // Delete categoria by id
    @DeleteMapping("/categoria/delete/{id}")
    public ResponseEntity <Categoria> eliminarPorId(Long id) {
        if(categoriaService.existCategoria(id)) {
            categoriaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new RuntimeException("No existe la categoria");
    }

    //Delete categirias All
    @DeleteMapping("/categoria/delete")
    public ResponseEntity <Categoria> eliminarTodas() {
        categoriaService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Save categoria
    @PostMapping("/categoria/save")
    public ResponseEntity <Categoria> guardar(Categoria categoria) {
        if (!categoriaService.existCategoria(categoria.getId())){
            categoriaService.create(categoria);
            return new ResponseEntity<>(HttpStatus.OK);}
        throw new RuntimeException("Ya existe la categoria");
    }

    // Update categoria
    @PutMapping("/categoria/update")
    public ResponseEntity <Categoria> actualizar(Categoria categoria) {
        if (categoriaService.existCategoria(categoria.getId())){
            categoriaService.updateById(categoria);
            return new ResponseEntity<>(HttpStatus.OK);}
        throw new RuntimeException("No existe la categoria");
    }
}


