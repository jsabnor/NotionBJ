package com.equipo2.NotionBJ.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase que define un articulo del Notion
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */


//Crear Entidad Articulo

@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("Clave primaria")
    private Long id;

    // Atributo autor del articulo
    private String autor;

    @ApiModelProperty("Fecha de creación")
    private LocalDate fecha;

    @ApiModelProperty("Titulo del Articulo")
    private String titulo;

    @ApiModelProperty("Contenido del Articulo")
    private String contenido;

    // Relacion ManyToOne con Categoria


    @JsonManagedReference
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;



    // Create constructor
    public Articulo() {
    }

    public Articulo(String autor,LocalDate fecha, String titulo, String contenido, Categoria categoria) {
        this.autor = autor;
        this.fecha = fecha;
        this.titulo = titulo;
        this.contenido = contenido;
        this.categoria = categoria;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor;}

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
