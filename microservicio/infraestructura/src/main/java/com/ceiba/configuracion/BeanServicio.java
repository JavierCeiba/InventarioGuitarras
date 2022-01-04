package com.ceiba.configuracion;

import com.ceiba.guitarra.puerto.repositorio.RepositorioEnvio;
import com.ceiba.guitarra.puerto.repositorio.RepositorioGuitarra;
import com.ceiba.guitarra.puerto.repositorio.RepositorioUsuario;
import com.ceiba.guitarra.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearGuitarra servicioCrearGuitarra(RepositorioGuitarra repositorioGuitarra) {
        return new ServicioCrearGuitarra(repositorioGuitarra);
    }

    @Bean
    public ServicioCrearEnvio servicioCrearEnvio(RepositorioEnvio repositorioEnvio) {
        return new ServicioCrearEnvio(repositorioEnvio);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarGuitarra servicioEliminarGuitarra(RepositorioGuitarra repositorioGuitarra) {
        return new ServicioEliminarGuitarra(repositorioGuitarra);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarGuitarra servicioActualizarGuitarra(RepositorioGuitarra repositorioGuitarra) {
        return new ServicioActualizarGuitarra(repositorioGuitarra);
    }

}
