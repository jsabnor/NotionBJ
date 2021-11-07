package com.equipo2.NotionBJ.controllers;


import com.equipo2.NotionBJ.Entities.Articulo;
import com.equipo2.NotionBJ.Services.ArticuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin(origins = "*",
        methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},
        allowedHeaders = {"*"})
public class ArticuloController {

    // Atributos
    private ArticuloService articuloService;

    // Constructor
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }
    // Método find all
    @GetMapping("/articulos")
    public ResponseEntity<List<Articulo>> mostrartodos(){
        return new ResponseEntity<>(articuloService.findAll(), HttpStatus.OK);
    }

    //Metodo find by id
     @GetMapping("/articulos/{id}") public ResponseEntity<Articulo> findById(Long id) {
         if (articuloService.existeArticulo(id)) {
             return new ResponseEntity<>(articuloService.findById(id), HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

    // Metodo post
    @PostMapping("/articulos/crear")
    public ResponseEntity<Articulo> crearArticulo (Articulo articulo){
        return new ResponseEntity<>(articuloService.save(articulo), HttpStatus.CREATED);
    }

    // Metodo update si existeArticulo true
    @PutMapping("/articulos/{id}")
    public ResponseEntity<Articulo> updateArticulo(@PathVariable Long id, Articulo articulo) {
        if (articuloService.existeArticulo(id)) {
            return new ResponseEntity<>(articuloService.updateArticulo(articulo), HttpStatus.OK);
        }
        throw new RuntimeException("No existe el articulo con id : " + id);
    }

    // Metodo delete by id
    @DeleteMapping("/articulos/{id}")
    public ResponseEntity<Articulo> deleteArticulo(@PathVariable Long id){
        if (articuloService.existeArticulo(id)){
            articuloService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new RuntimeException("No existe el articulo con id : " + id );
    }

    // Delete all
    @DeleteMapping("/articulos")
    public ResponseEntity<Articulo> deleteAll(){
        articuloService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Find by autor
    @GetMapping("/articulos/autor/{autor}")
    public ResponseEntity<List<Articulo>> findByAutor(@PathVariable String autor){
        return new ResponseEntity<>(articuloService.findByAutor(autor), HttpStatus.OK);
    }

    // Find by categoria
    @GetMapping("/articulos/categoria/{categoria}")
    public ResponseEntity<List<Articulo>> findByCategoria(@PathVariable String categoria){
        return new ResponseEntity<>(articuloService.findByCategoria(categoria), HttpStatus.OK);
    }

    // GETTER AND SETTER
    public ArticuloService getArticuloService() {
        return articuloService;
    }
}





