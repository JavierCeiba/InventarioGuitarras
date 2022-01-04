package com.ceiba.guitarra.servicio.testdatabuilder;

import com.ceiba.guitarra.modelo.entidad.Envio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EnvioTestDataBuilder {

    private Long id;
    private Long idGuitarra;
    private Long idEmpresa;
    private LocalDateTime fechaEnvío;
    private LocalDate fechaEntrega;
    private Double valorTotal;

    public EnvioTestDataBuilder() {
        idGuitarra = 1L;
        idEmpresa = 2L;
        fechaEnvío = LocalDateTime.now();
        valorTotal = 3500d;
    }

    public EnvioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public EnvioTestDataBuilder conIdGuitarra(Long idGuitarra) {
        this.idGuitarra = idGuitarra;
        return this;
    }

    public EnvioTestDataBuilder conIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
        return this;
    }

    public EnvioTestDataBuilder conFechaDeEnvio(LocalDateTime fechaEnvío) {
        this.fechaEnvío = fechaEnvío;
        return this;
    }

    public EnvioTestDataBuilder conValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Envio build() {
        return new Envio(id, idGuitarra, idEmpresa, fechaEnvío, valorTotal);
    }
}
