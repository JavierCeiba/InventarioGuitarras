package com.ceiba.guitarra.controlador;

import com.ceiba.guitarra.consulta.ManejadorListarEmpresas;
import com.ceiba.guitarra.modelo.dto.DtoEmpresa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@Api(tags={"Controlador consulta empresa"})
public class ConsultaControladorEmpresa {

    private final ManejadorListarEmpresas manejadorListarEmpresas;

    public ConsultaControladorEmpresa(ManejadorListarEmpresas manejadorListarEmpresas) {
        this.manejadorListarEmpresas = manejadorListarEmpresas;
    }

    @GetMapping
    @ApiOperation("Listar Empresas")
    public List<DtoEmpresa> listar() {
        return this.manejadorListarEmpresas.ejecutar();
    }

}
