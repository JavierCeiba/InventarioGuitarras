package com.ceiba.guitarra.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.guitarra.servicio.ServicioEliminarGuitarra;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarGuitarra implements ManejadorComando<Long> {

    private final ServicioEliminarGuitarra servicioEliminarGuitarra;

    public ManejadorEliminarGuitarra(ServicioEliminarGuitarra servicioEliminarGuitarra) {
        this.servicioEliminarGuitarra = servicioEliminarGuitarra;
    }

    public void ejecutar(Long idGuitarra) {
        this.servicioEliminarGuitarra.ejecutar(idGuitarra);
    }
}
