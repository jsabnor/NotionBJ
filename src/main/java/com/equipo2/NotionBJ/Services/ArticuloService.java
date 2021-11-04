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
        Optional<Articulo> articuloOptional=articuloRepository.findById(id);
        if(articuloOptional.isPresent()) {
            return articuloOptional.get();
        }
        throw new NoSuchElementException();
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
        if(articuloRepository.existsById(articulo.getId())) {
            return articuloRepository.save(articulo);
        }
        throw new NoSuchElementException();
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
        if(articuloRepository.existsById(id)){
            articuloRepository.deleteById(id);
        }
        throw new NoSuchElementException();
    }

}
