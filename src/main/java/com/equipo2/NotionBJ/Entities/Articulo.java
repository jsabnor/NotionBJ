package com.equipo2.NotionBJ.Entities;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.time.LocalDate;


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

    @ApiModelProperty("Fecha de creación")
    @Column(name = "fecha_articulo", nullable = false)
    private LocalDate fecha;

    @ApiModelProperty("Titulo del Articulo")
    private String titulo;

    @ApiModelProperty("Contenido del Articulo")
    private String contenido;

    //autor
    @ManyToOne()
    @JoinColumn(name="categoria_id")
    private Categoria categoria;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
