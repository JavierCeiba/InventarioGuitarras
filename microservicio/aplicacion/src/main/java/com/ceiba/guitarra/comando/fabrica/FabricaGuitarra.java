package com.ceiba.guitarra.comando.fabrica;

import com.ceiba.guitarra.comando.ComandoGuitarra;
import com.ceiba.guitarra.modelo.entidad.Guitarra;
import org.springframework.stereotype.Component;

@Component
public class FabricaGuitarra {

    public Guitarra crear(ComandoGuitarra comandoGuitarra) {
        return new Guitarra(
                comandoGuitarra.getId(),
                comandoGuitarra.getMarca(),
                comandoGuitarra.getTipo(),
                comandoGuitarra.getReferencia(),
                comandoGuitarra.getPrecio(),
                comandoGuitarra.getEnviado()
        );
    }

}
