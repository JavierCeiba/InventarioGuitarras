package com.ceiba.guitarra.servicio;

import com.ceiba.guitarra.puerto.repositorio.RepositorioGuitarra;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarGuitarraTest {

    @Test
    @DisplayName("Deberia eliminar la guitarra llamando al repositorio")
    void deberiaEliminarLaGuitarraLlamandoAlRepositorio() {
        RepositorioGuitarra repositorioGuitarra = Mockito.mock(RepositorioGuitarra.class);
        ServicioEliminarGuitarra servicioEliminarGuitarra = new ServicioEliminarGuitarra(repositorioGuitarra);

        servicioEliminarGuitarra.ejecutar(1l);

        Mockito.verify(repositorioGuitarra, Mockito.times(1)).eliminar(1l);

    }

}
