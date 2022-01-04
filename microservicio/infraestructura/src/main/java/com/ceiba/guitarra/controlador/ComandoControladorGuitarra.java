package com.ceiba.guitarra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.guitarra.comando.ComandoGuitarra;
import com.ceiba.guitarra.comando.manejador.ManejadorActualizarGuitarra;
import com.ceiba.guitarra.comando.manejador.ManejadorCrearGuitarra;
import com.ceiba.guitarra.comando.manejador.ManejadorEliminarGuitarra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guitarras")
@Api(tags = { "Controlador comando guitarra"})
public class ComandoControladorGuitarra {

    private final ManejadorCrearGuitarra manejadorCrearGuitarra;
	private final ManejadorEliminarGuitarra manejadorEliminarGuitarra;
	private final ManejadorActualizarGuitarra manejadorActualizarGuitarra;

    @Autowired
    public ComandoControladorGuitarra(ManejadorCrearGuitarra manejadorCrearGuitarra,
									  ManejadorEliminarGuitarra manejadorEliminarGuitarra,
									  ManejadorActualizarGuitarra manejadorActualizarGuitarra) {
        this.manejadorCrearGuitarra = manejadorCrearGuitarra;
		this.manejadorEliminarGuitarra = manejadorEliminarGuitarra;
		this.manejadorActualizarGuitarra = manejadorActualizarGuitarra;
    }

    @PostMapping
    @ApiOperation("Crear Guitarra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoGuitarra comandoGuitarra) {
        return manejadorCrearGuitarra.ejecutar(comandoGuitarra);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Guitarra")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarGuitarra.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Guitarra")
	public void actualizar(@RequestBody ComandoGuitarra comandoGuitarra,@PathVariable Long id) {
		comandoGuitarra.setId(id);
		manejadorActualizarGuitarra.ejecutar(comandoGuitarra);
	}
}
