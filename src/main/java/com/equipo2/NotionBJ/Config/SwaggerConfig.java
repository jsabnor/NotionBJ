package com.equipo2.NotionBJ.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Clase de configuracion de Swagger. Para crear la documentacion de la API REST
 * Todos los archivos de configuracion se marcan con @Configuration
 *
 * @version 1.0
 */
@Configuration
public class SwaggerConfig {

    //METODOS


    /**
     * Metodo que devuleve un Docket que es un builder que genera la web de la API REST
     * @return un Docket
     */

    @Bean
    public Docket api(){
        //version mas simplificada del Docket. Se puede construir de muchas formas
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ApiInfo.DEFAULT)//
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();

    }

    /**
     * Metodo ApiInfo para pasarlo al builder del Docket
     * @return ApiInfo
     */
    private ApiInfo apiDetails(){
        //Devolvemos el ApiInfo
        return new ApiInfo("NotionBJ",
                "Libreria de API REST NotionBJ",
                "1.0",
                "www.google.es",
                new Contact("EQUIPO FRONT: heyanababana, Javier_scr EQUIPO BACK: Clemen, Josema","www.google.es", "info@equipo2.com"),
                "GNU",
                "https://www.gnu.com",
                Collections.emptyList());
    }
}
