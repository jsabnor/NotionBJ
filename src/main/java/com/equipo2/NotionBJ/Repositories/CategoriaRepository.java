package com.equipo2.NotionBJ.Repositories;

import com.equipo2.NotionBJ.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository del Categoria
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
