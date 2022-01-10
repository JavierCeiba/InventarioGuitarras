package com.ceiba.guitarra.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEnvio {

    private Long id;
    private Long idGuitarra;
    private Long idEmpresa;
    private String fechaEnvio;
}
