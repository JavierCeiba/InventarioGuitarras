package com.ceiba.guitarra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.guitarra.modelo.entidad.Guitarra;
import com.ceiba.guitarra.puerto.repositorio.RepositorioGuitarra;
import com.ceiba.guitarra.servicio.testdatabuilder.GuitarraTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearGuitarraTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la Guitarra")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeLaGuitarra() {
        // arrange
        Guitarra guitarra = new GuitarraTestDataBuilder().conId(1L).build();
        RepositorioGuitarra repositorioGuitarra = Mockito.mock(RepositorioGuitarra.class);
        Mockito.when(repositorioGuitarra.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearGuitarra servicioCrearGuitarra = new ServicioCrearGuitarra(repositorioGuitarra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearGuitarra.ejecutar(guitarra),
                ExcepcionDuplicidad.class,"La guitarra ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear la guitarra de manera correcta")
    void deberiaCrearLaGuitarraDeManeraCorrecta() {
        // arrange
        Guitarra guitarra = new GuitarraTestDataBuilder().build();
        RepositorioGuitarra repositorioGuitarra = Mockito.mock(RepositorioGuitarra.class);
        Mockito.when(repositorioGuitarra.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioGuitarra.crear(guitarra)).thenReturn(10L);
        ServicioCrearGuitarra servicioCrearGuitarra = new ServicioCrearGuitarra(repositorioGuitarra);
        // act
        Long idGuitarra = servicioCrearGuitarra.ejecutar(guitarra);
        //- assert
        assertEquals(10L,idGuitarra);
        Mockito.verify(repositorioGuitarra, Mockito.times(1)).crear(guitarra);
    }
}
