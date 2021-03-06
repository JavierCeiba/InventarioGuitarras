package com.ceiba.guitarra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.guitarra.comando.ComandoEnvio;
import com.ceiba.guitarra.comando.fabrica.FabricaEnvio;
import com.ceiba.guitarra.modelo.entidad.Envio;
import com.ceiba.guitarra.servicio.ServicioCrearEnvio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEnvio implements ManejadorComandoRespuesta<ComandoEnvio, ComandoRespuesta<Long>> {

    private final FabricaEnvio fabricaEnvio;
    private final ServicioCrearEnvio servicioCrearEnvio;

    public ManejadorCrearEnvio(FabricaEnvio fabricaEnvio, ServicioCrearEnvio servicioCrearEnvio) {
        this.fabricaEnvio = fabricaEnvio;
        this.servicioCrearEnvio = servicioCrearEnvio;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEnvio comandoEnvio) {
        Envio envio = this.fabricaEnvio.crear(comandoEnvio);
        envio.setValorTotal(this.fabricaEnvio.generarValorTotal(envio.getIdGuitarra()));
        return new ComandoRespuesta<>(this.servicioCrearEnvio.ejecutar(envio));
    }
}
