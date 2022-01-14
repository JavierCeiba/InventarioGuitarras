package com.ceiba.guitarra.comando.fabrica;

import com.ceiba.guitarra.comando.ComandoEnvio;
import com.ceiba.guitarra.comando.manejador.ManejadorActualizarGuitarra;
import com.ceiba.guitarra.consulta.ManejadorObtenerGuitarra;
import com.ceiba.guitarra.modelo.dto.DtoGuitarra;
import com.ceiba.guitarra.modelo.entidad.Envio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class FabricaEnvio {

    @Autowired
    private ManejadorObtenerGuitarra obtenerGuitarra;
    @Autowired
    private ManejadorActualizarGuitarra actualizarGuitarra;

    public Envio crear(ComandoEnvio comandoEnvio) {
        return new Envio(
                comandoEnvio.getId(),
                comandoEnvio.getIdGuitarra(),
                comandoEnvio.getIdEmpresa(),
                generarFecha(comandoEnvio.getFechaEnvio())
        );
    }

    private LocalDate generarFecha(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fecha, formatter);
    }

    public Double generarValorTotal(Long idGuitarra){
        DtoGuitarra guitarra = obtenerGuitarra.ejecutar(idGuitarra);
        return guitarra.getPrecio() + 100d;
    }

}
