package com.ceiba.guitarra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.guitarra.modelo.entidad.Guitarra;
import com.ceiba.guitarra.puerto.repositorio.RepositorioGuitarra;
import com.ceiba.guitarra.servicio.testdatabuilder.GuitarraTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarGuitarraTest {

    @Test
    @DisplayName("Deberia validar la existencia previa de la guitarra")
    void deberiaValidarLaExistenciaPreviaDeLaGuitarra() {
        // arrange
        Guitarra guitarra = new GuitarraTestDataBuilder().conId(1L).build();
        RepositorioGuitarra repositorioGuitarra = Mockito.mock(RepositorioGuitarra.class);
        Mockito.when(repositorioGuitarra.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarGuitarra servicioActualizarGuitarra = new ServicioActualizarGuitarra(repositorioGuitarra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarGuitarra.ejecutar(guitarra),
                ExcepcionDuplicidad.class,"La guitarra no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Guitarra guitarra = new GuitarraTestDataBuilder().conId(1L).build();
        RepositorioGuitarra repositorioGuitarra = Mockito.mock(RepositorioGuitarra.class);
        Mockito.when(repositorioGuitarra.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarGuitarra servicioActualizarGuitarra = new ServicioActualizarGuitarra(repositorioGuitarra);
        // act
        servicioActualizarGuitarra.ejecutar(guitarra);
        //assert
        Mockito.verify(repositorioGuitarra,Mockito.times(1)).actualizar(guitarra);
    }
}
