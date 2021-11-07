package com.equipo2.NotionBJ.Services;

import com.equipo2.NotionBJ.Entities.Articulo;
import com.equipo2.NotionBJ.Repositories.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Service de Articulo
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@Service
public class ArticuloService {
    private final ArticuloRepository articuloRepository;

    /**
     * Constructor con el parametro de ArticuloRepository
     * @param articuloRepository repository de Articulo
     */
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    /**
     * Metodo que devuelve todos los articulos
     * @return Lista con todos los articulos
     */
    public List<Articulo> findAll(){
        return articuloRepository.findAll();
    }

    /**
     * Metodo que devulve un aticulo de la base de datos buscado por id.Si no lo encuentra
     * lanza una excepcion.
     * @param id del articulo
     * @return objeto Articulo.
     */

    public Articulo findById(Long id){
        return articuloRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No existe el articulo"));
    }

    /**
     * Metodo que crea un articulo en la base de datos
     * @param articulo que pasamos por el body
     * @return el articulo creado
     */
    public Articulo save(Articulo articulo){
        return articuloRepository.save(articulo);
    }

    /**
     * Metodo que actuliza un articulo si existe en la base de datos
     * @param articulo que pasamos por el body
     * @return el articulo actualizado
     */
    public Articulo updateArticulo(Articulo articulo){

            return articuloRepository.save(articulo);

    }

    /**
     * Metodo que elimina todos los articulos de la base de datos
     */
    public void deleteAll(){
        articuloRepository.deleteAll();
    }

    /**
     * Metodo que elimina un articulo por id
     * @param id del articulo a eliminar
     */
    public void deleteById(Long id){

            articuloRepository.deleteById(id);

    }

    // existeArticulo
    /**
     * Metodo que comprueba si existe un articulo en la base de datos
     * @param id del articulo
     * @return true si existe, false si no existe
     */
    public boolean existeArticulo(Long id){
        return articuloRepository.existsById(id);
    }

    // findBy Autor
    public List<Articulo> findByAutor(String autor) {
        return articuloRepository.findByAutor(autor);

    }

    // find by categoria
    public List<Articulo> findByCategoria(String categoria) {
        return articuloRepository.findByCategoria(categoria);
    }
}


