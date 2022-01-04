package com.ceiba.guitarra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoGuitarra {
    private Long id;
    private String marca;
    private String tipo;
    private String referencia;
    private Double precio;
    private Boolean enviado;

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }
}
