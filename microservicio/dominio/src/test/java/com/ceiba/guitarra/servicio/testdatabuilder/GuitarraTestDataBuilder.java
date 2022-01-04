package com.ceiba.guitarra.servicio.testdatabuilder;

import com.ceiba.guitarra.modelo.entidad.Guitarra;

public class GuitarraTestDataBuilder {

    private Long id;
    private String marca;
    private String tipo;
    private String referencia;
    private Double precio;
    private Boolean enviado;

    public GuitarraTestDataBuilder() {
        marca = "Fender";
        tipo = "LessPaul";
        referencia = "wjwe245";
        precio = 2500d;
        enviado = false;
    }

    public GuitarraTestDataBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public GuitarraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public GuitarraTestDataBuilder conTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public GuitarraTestDataBuilder conReferencia(String referencia) {
        this.referencia = referencia;
        return this;
    }

    public GuitarraTestDataBuilder conPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public GuitarraTestDataBuilder conEnvio(Boolean enviado) {
        this.enviado = enviado;
        return this;
    }

    public Guitarra build() {
        return new Guitarra(id, marca, tipo, referencia, precio, enviado);
    }
}
