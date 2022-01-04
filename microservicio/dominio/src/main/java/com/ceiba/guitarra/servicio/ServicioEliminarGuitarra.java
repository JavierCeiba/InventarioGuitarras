package com.ceiba.guitarra.servicio;

import com.ceiba.guitarra.puerto.repositorio.RepositorioGuitarra;

public class ServicioEliminarGuitarra {

    private final RepositorioGuitarra repositorioGuitarra;

    public ServicioEliminarGuitarra(RepositorioGuitarra repositorioGuitarra) {
        this.repositorioGuitarra = repositorioGuitarra;
    }

    public void ejecutar(Long id) {
        this.repositorioGuitarra.eliminar(id);
    }
}
