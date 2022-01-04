package com.ceiba.guitarra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.guitarra.modelo.entidad.Guitarra;
import com.ceiba.guitarra.servicio.testdatabuilder.GuitarraTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuitarraTest {

    @Test
    @DisplayName("Deberia crear correctamente la guitarra")
    void deberiaCrearCorrectamenteLaGuitarra() {
        // arrange
        Double precio = 3400d;
        //act
        Guitarra guitarra = new GuitarraTestDataBuilder().conId(2L)
                .conMarca("Gibson").conPrecio(precio).build();
        //assert
        assertEquals(2, guitarra.getId());
        assertEquals("Gibson", guitarra.getMarca());
        assertEquals("LessPaul", guitarra.getTipo());
        assertEquals("wjwe245", guitarra.getReferencia());
        assertEquals(3400, guitarra.getPrecio());
        assertEquals(false, guitarra.getEnviado());
    }

    @Test
    void deberiaFallarSinMarcaDeGuitarra() {

        //Arrange
        GuitarraTestDataBuilder guitarraTestDataBuilder = new GuitarraTestDataBuilder()
                .conMarca(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    guitarraTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la marca de la guitarra");
    }

    @Test
    void deberiaFallarSinTipoDeGuitarra() {

        //Arrange
        GuitarraTestDataBuilder guitarraTestDataBuilder = new GuitarraTestDataBuilder()
                .conTipo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    guitarraTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de guitarra");
    }

    @Test
    void deberiaFallarSinReferenciaDeGuitarra() {

        //Arrange
        GuitarraTestDataBuilder guitarraTestDataBuilder = new GuitarraTestDataBuilder()
                .conReferencia(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    guitarraTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la referencia de la guitarra");
    }

    @Test
    void deberiaFallarSinPrecioDeGuitarra() {

        //Arrange
        GuitarraTestDataBuilder guitarraTestDataBuilder = new GuitarraTestDataBuilder()
                .conPrecio(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    guitarraTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el precio de la guitarra");
    }

}
