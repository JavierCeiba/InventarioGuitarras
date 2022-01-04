package com.ceiba.guitarra.servicio.testdatabuilder;

import com.ceiba.guitarra.comando.ComandoEnvio;

public class ComandoEnvioTestDataBuilder {

    private Long id;
    private Long id_guitarra;
    private Long id_empresa;
    private String fecha_envío;

    public ComandoEnvioTestDataBuilder() {
        id_guitarra = 1L;
        id_empresa = 2L;
        fecha_envío = "2022-01-11 12:30";
    }

    public ComandoEnvioTestDataBuilder conId_guitarra(Long id_guitarra) {
        this.id_guitarra = id_guitarra;
        return this;
    }

    public ComandoEnvioTestDataBuilder conId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
        return this;
    }

    public ComandoEnvio build() {
        return new ComandoEnvio(id, id_guitarra, id_empresa, fecha_envío);
    }
}
