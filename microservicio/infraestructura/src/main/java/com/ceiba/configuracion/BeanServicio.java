package com.ceiba.configuracion;

import com.ceiba.guitarra.puerto.repositorio.RepositorioEnvio;
import com.ceiba.guitarra.puerto.repositorio.RepositorioGuitarra;
import com.ceiba.guitarra.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearGuitarra servicioCrearGuitarra(RepositorioGuitarra repositorioGuitarra) {
        return new ServicioCrearGuitarra(repositorioGuitarra);
    }

    @Bean
    public ServicioCrearEnvio servicioCrearEnvio(RepositorioEnvio repositorioEnvio) {
        return new ServicioCrearEnvio(repositorioEnvio);
    }

    @Bean
    public ServicioEliminarGuitarra servicioEliminarGuitarra(RepositorioGuitarra repositorioGuitarra) {
        return new ServicioEliminarGuitarra(repositorioGuitarra);
    }

    @Bean
    public ServicioActualizarGuitarra servicioActualizarGuitarra(RepositorioGuitarra repositorioGuitarra) {
        return new ServicioActualizarGuitarra(repositorioGuitarra);
    }

}
