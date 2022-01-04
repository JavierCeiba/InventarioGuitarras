package com.ceiba.guitarra.servicio.testdatabuilder;

import com.ceiba.guitarra.comando.ComandoGuitarra;

public class ComandoGuitarraTestDataBuilder {

    private Long id;
    private String marca;
    private String tipo;
    private String referencia;
    private Double precio;
    private Boolean enviado;

    public ComandoGuitarraTestDataBuilder() {
        marca = "Fender";
        tipo = "LessPaul";
        referencia = "wjwe245";
        precio = 2500d;
        enviado = false;
    }

    public ComandoGuitarraTestDataBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public ComandoGuitarra build() {
        return new ComandoGuitarra(id, marca, tipo, referencia, precio, enviado);
    }
}
