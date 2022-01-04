package com.ceiba.guitarra.controlador;

import com.ceiba.guitarra.consulta.ManejadorListarGuitarras;
import com.ceiba.guitarra.modelo.dto.DtoGuitarra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guitarras")
@Api(tags={"Controlador consulta guitarra"})
public class ConsultaControladorGuitarra {

    private final ManejadorListarGuitarras manejadorListarGuitarras;

    public ConsultaControladorGuitarra(ManejadorListarGuitarras manejadorListarGuitarras) {
        this.manejadorListarGuitarras = manejadorListarGuitarras;
    }

    @GetMapping
    @ApiOperation("Listar Guitarras")
    public List<DtoGuitarra> listar() {
        return this.manejadorListarGuitarras.ejecutar();
    }

}
