package com.equipo2.NotionBJ.Repositories;

import com.equipo2.NotionBJ.Entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository del Articulo
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    //Buscar todos los articulos de una categoria especifica
    @Query("select a from articulos a where categoria=?1")
    List<Articulo> findByCategoria(String categoria);

    //Buscar todos los articulos de un autor
    @Query("select a from articulos a where autor=?1")
    List<Articulo> findByAutor(String Autor);
}
