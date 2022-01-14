package com.ceiba.guitarra.servicio.testdatabuilder;

import com.ceiba.guitarra.modelo.entidad.Envio;

import java.time.LocalDate;

public class EnvioTestDataBuilder {

    private Long id;
    private Long idGuitarra;
    private Long idEmpresa;
    private LocalDate fechaEnvio;
    private LocalDate fechaEntrega;
    private Double valorTotal;

    public EnvioTestDataBuilder() {
        idGuitarra = 1L;
        idEmpresa = 2L;
        fechaEnvio = LocalDate.now();
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

    public EnvioTestDataBuilder conFechaDeEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
        return this;
    }

    public EnvioTestDataBuilder conValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Envio build() {
        Envio envio = new Envio(id, idGuitarra, idEmpresa, fechaEnvio);
        envio.setValorTotal(valorTotal);
        return envio;
    }
}
