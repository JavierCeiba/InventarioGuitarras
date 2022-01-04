package com.ceiba.guitarra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.guitarra.comando.ComandoGuitarra;
import com.ceiba.guitarra.comando.fabrica.FabricaGuitarra;
import com.ceiba.guitarra.modelo.entidad.Guitarra;
import com.ceiba.guitarra.servicio.ServicioCrearGuitarra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearGuitarra implements ManejadorComandoRespuesta<ComandoGuitarra, ComandoRespuesta<Long>> {

    private final FabricaGuitarra fabricaGuitarra;
    private final ServicioCrearGuitarra servicioCrearGuitarra;

    public ManejadorCrearGuitarra(FabricaGuitarra fabricaGuitarra, ServicioCrearGuitarra servicioCrearGuitarra) {
        this.fabricaGuitarra = fabricaGuitarra;
        this.servicioCrearGuitarra = servicioCrearGuitarra;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoGuitarra comandoGuitarra) {
        Guitarra guitarra = this.fabricaGuitarra.crear(comandoGuitarra);
        return new ComandoRespuesta<>(this.servicioCrearGuitarra.ejecutar(guitarra));
    }
}
