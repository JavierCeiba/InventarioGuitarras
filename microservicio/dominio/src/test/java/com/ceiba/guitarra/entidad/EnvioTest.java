package com.ceiba.guitarra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.guitarra.modelo.entidad.Envio;
import com.ceiba.guitarra.servicio.testdatabuilder.EnvioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnvioTest {

    @Test
    @DisplayName("Deberia crear correctamente el envio")
    void deberiaCrearCorrectamenteElEnvio() {
        // arrange
        Double valorTotal = 3650d;
        LocalDate fechaEnvio = LocalDate.now();
        //act
        Envio envio = new EnvioTestDataBuilder().conId(3L)
                .conFechaDeEnvio(fechaEnvio).conValorTotal(valorTotal).build();
        //assert
        assertEquals(3, envio.getId());
        assertEquals(1, envio.getIdGuitarra());
        assertEquals(2, envio.getIdEmpresa());
        assertEquals(fechaEnvio, envio.getFechaEnvio());
        assertEquals(3650d, envio.getValorTotal());
    }

    @Test
    void deberiaFallarEnvioSinGuitarra() {

        //Arrange
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder()
                .conIdGuitarra(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    envioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe seleccionar la guitarra");
    }

    @Test
    void deberiaFallarEnvioSinEmpresa() {

        //Arrange
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder()
                .conIdEmpresa(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    envioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe seleccionar la empresa");
    }

    @Test
    void deberiaFallarEnvioSinFechaEnvio() {

        //Arrange
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder()
                .conFechaDeEnvio(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    envioTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de envío");
    }

}
