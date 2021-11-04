package com.equipo2.NotionBJ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Entrada al programa
 * PROYECTO NOTION BJ
 * Equipo Front: heyanabanana y Javier_scr
 * Equipo Back: Clemen y Josema
 * @author Clemen y Josema
 * @version 1.0
 */
@SpringBootApplication
public class NotionBjApplication {

	public static void main(String[] args) {
		//Creamos el context
		ApplicationContext context=SpringApplication.run(NotionBjApplication.class, args);
	}

}
