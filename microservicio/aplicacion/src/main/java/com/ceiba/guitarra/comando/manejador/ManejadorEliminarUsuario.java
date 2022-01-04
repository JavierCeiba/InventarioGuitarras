package com.ceiba.guitarra.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.guitarra.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarUsuario implements ManejadorComando<Long> {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ManejadorEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarUsuario.ejecutar(idUsuario);
    }
}
