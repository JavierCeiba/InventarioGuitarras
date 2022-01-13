package com.ceiba.guitarra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoEnvio {
    private Long id;
    private DtoGuitarra guitarra;
    private DtoEmpresa empresa;
    private LocalDate fechaEnvio;
    private LocalDate fechaEntrega;
    private Double valorTotal;

}
