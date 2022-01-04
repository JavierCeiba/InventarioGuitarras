package com.ceiba.guitarra.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.guitarra.comando.ComandoGuitarra;
import com.ceiba.guitarra.comando.fabrica.FabricaGuitarra;
import com.ceiba.guitarra.modelo.entidad.Guitarra;
import com.ceiba.guitarra.servicio.ServicioActualizarGuitarra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarGuitarra implements ManejadorComando<ComandoGuitarra> {

    private final FabricaGuitarra fabricaGuitarra;
    private final ServicioActualizarGuitarra servicioActualizarGuitarra;

    public ManejadorActualizarGuitarra(FabricaGuitarra fabricaGuitarra, ServicioActualizarGuitarra servicioActualizarGuitarra) {
        this.fabricaGuitarra = fabricaGuitarra;
        this.servicioActualizarGuitarra = servicioActualizarGuitarra;
    }

    public void ejecutar(ComandoGuitarra comandoGuitarra) {
        Guitarra guitarra = this.fabricaGuitarra.crear(comandoGuitarra);
        this.servicioActualizarGuitarra.ejecutar(guitarra);
    }
}
