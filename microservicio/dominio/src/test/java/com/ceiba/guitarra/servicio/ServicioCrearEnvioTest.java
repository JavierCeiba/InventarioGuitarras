package com.ceiba.guitarra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.guitarra.modelo.entidad.Envio;
import com.ceiba.guitarra.puerto.repositorio.RepositorioEnvio;
import com.ceiba.guitarra.servicio.testdatabuilder.EnvioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearEnvioTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del envio")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelEnvio() {
        // arrange
        Envio envio = new EnvioTestDataBuilder().conId(1L).build();
        RepositorioEnvio repositorioEnvio = Mockito.mock(RepositorioEnvio.class);
        Mockito.when(repositorioEnvio.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearEnvio servicioCrearEnvio = new ServicioCrearEnvio(repositorioEnvio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEnvio.ejecutar(envio),
                ExcepcionDuplicidad.class,"El envio ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se envie una guitarra el sabado")
    void deberiaLanzarUnaExepcionCuandoSeHagaUnEnvioElSabado() {
        // arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaEnvio = LocalDate.parse("2022-01-08", formatter);
        Envio envio = new EnvioTestDataBuilder().conId(1L).conFechaDeEnvio(fechaEnvio).build();
        RepositorioEnvio repositorioEnvio = Mockito.mock(RepositorioEnvio.class);
        Mockito.when(repositorioEnvio.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioCrearEnvio servicioCrearEnvio = new ServicioCrearEnvio(repositorioEnvio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEnvio.ejecutar(envio),
                ExcepcionValorInvalido.class,"La fecha de envio no puede ser fines de semana");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se envie una guitarra el domingo")
    void deberiaLanzarUnaExepcionCuandoSeHagaUnEnvioElDomingo() {
        // arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaEnvio = LocalDate.parse("2022-01-09", formatter);
        Envio envio = new EnvioTestDataBuilder().conId(1L).conFechaDeEnvio(fechaEnvio).build();
        RepositorioEnvio repositorioEnvio = Mockito.mock(RepositorioEnvio.class);
        Mockito.when(repositorioEnvio.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioCrearEnvio servicioCrearEnvio = new ServicioCrearEnvio(repositorioEnvio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEnvio.ejecutar(envio),
                ExcepcionValorInvalido.class,"La fecha de envio no puede ser fines de semana");
    }

    @Test
    @DisplayName("Deberia Crear el envio de manera correcta")
    void deberiaCrearElEnvioDeManeraCorrecta() {
        // arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaEnvio = LocalDate.parse("2022-01-11", formatter);
        Double valorTotal = 2500d;
        Envio envio = new EnvioTestDataBuilder().conValorTotal(valorTotal)
                .conFechaDeEnvio(fechaEnvio).build();
        RepositorioEnvio repositorioEnvio = Mockito.mock(RepositorioEnvio.class);
        Mockito.when(repositorioEnvio.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioEnvio.crear(envio)).thenReturn(5L);
        ServicioCrearEnvio servicioCrearEnvio = new ServicioCrearEnvio(repositorioEnvio);

        // act
        Long idEnvio = servicioCrearEnvio.ejecutar(envio);
        if (fechaEnvio.getDayOfWeek().equals(DayOfWeek.TUESDAY))
            valorTotal = valorTotal*.95;
        LocalDate fechaEntrega = generarFechaEntrega(LocalDate.from(fechaEnvio));

        //- assert
        assertEquals(5L,idEnvio);
        assertEquals(envio.getValorTotal(), valorTotal);
        assertEquals(envio.getFechaEntrega(), fechaEntrega);
        Mockito.verify(repositorioEnvio, Mockito.times(1)).crear(envio);
    }

    private LocalDate generarFechaEntrega(LocalDate fechaEntrega){
        int diasEntrega = 3;
        do {
            fechaEntrega = fechaEntrega.plusDays(1);
            if (!fechaEntrega.getDayOfWeek().equals(DayOfWeek.SATURDAY) &&
                    !fechaEntrega.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                --diasEntrega;
            }
        } while (diasEntrega != 0);
        return fechaEntrega;
    }
}
