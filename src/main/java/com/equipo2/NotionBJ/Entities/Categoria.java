package com.equipo2.NotionBJ.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que define las categorias del Notion
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
// Create class category
@Entity
@Table(name = "categoria")
public class Categoria{

    // Create attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("Clave primaria")
    private Long id;

    @ApiModelProperty("Categoria ")
    private String categoria;

    // Relacion OneToMany con Articulos

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Articulo> articulos = new ArrayList<>();





    // Constructors

    public Categoria() {
    }

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    // Create getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    // Exists by id categoria
    public boolean existsById(Long id){
        return this.id.equals(id);
    }
}



