package com.ceiba.guitarra.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Guitarra {

    private static final String SE_DEBE_INGRESAR_LA_MARCA = "Se debe ingresar la marca de la guitarra";
    private static final String SE_DEBE_INGRESAR_EL_TIPO = "Se debe ingresar el tipo de guitarra";
    private static final String SE_DEBE_INGRESAR_LA_REFERENCIA = "Se debe ingresar la referencia de la guitarra";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO = "Se debe ingresar el precio de la guitarra";

    private Long id;
    private String marca;
    private String tipo;
    private String referencia;
    private Double precio;
    private Boolean enviado;

    public Guitarra(Long id, String marca, String tipo, String referencia, Double precio, Boolean enviado) {
        validarObligatorio(marca, SE_DEBE_INGRESAR_LA_MARCA);
        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO);
        validarObligatorio(referencia, SE_DEBE_INGRESAR_LA_REFERENCIA);

        this.id = id;
        this.marca = marca;
        this.tipo = tipo;
        this.referencia = referencia;
        this.precio = precio;
        this.enviado = enviado;

    }

}
