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



}
