package com.ceiba.guitarra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.guitarra.comando.ComandoEnvio;
import com.ceiba.guitarra.comando.manejador.ManejadorCrearEnvio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/envios")
@Api(tags = { "Controlador comando envio"})
public class ComandoControladorEnvio {

    private final ManejadorCrearEnvio manejadorCrearEnvio;

    @Autowired
    public ComandoControladorEnvio(ManejadorCrearEnvio manejadorCrearEnvio) {
        this.manejadorCrearEnvio = manejadorCrearEnvio;

    }

    @PostMapping
    @ApiOperation("Crear Envio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEnvio comandoEnvio) {
        return manejadorCrearEnvio.ejecutar(comandoEnvio);
    }

}
