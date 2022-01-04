package com.ceiba.guitarra.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoGuitarra {

    private Long id;
    private String marca;
    private String tipo;
    private String referencia;
    private Double precio;
    private Boolean enviado;
}
