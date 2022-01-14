package com.ceiba.guitarra.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@AllArgsConstructor
@Getter
public class Envio {

    private static final String SE_DEBE_SELECCIONAR_LA_GUITARRA = "Se debe seleccionar la guitarra";
    private static final String SE_DEBE_SELECCIONAR_LA_EMPRESA = "Se debe seleccionar la empresa";
    private static final String SE_DEBE_INGRESAR_LA_FECHA = "Se debe ingresar la fecha de envío";

    private Long id;
    private Long idGuitarra;
    private Long idEmpresa;
    private LocalDate fechaEnvio;
    private LocalDate fechaEntrega;
    private Double valorTotal;

    public Envio(Long id, Long idGuitarra, Long idEmpresa, LocalDate fechaEnvio) {
        validarObligatorio(idGuitarra, SE_DEBE_SELECCIONAR_LA_GUITARRA);
        validarObligatorio(idEmpresa, SE_DEBE_SELECCIONAR_LA_EMPRESA);
        validarObligatorio(fechaEnvio, SE_DEBE_INGRESAR_LA_FECHA);

        this.id = id;
        this.idGuitarra = idGuitarra;
        this.idEmpresa = idEmpresa;
        this.fechaEnvio = fechaEnvio;

    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
