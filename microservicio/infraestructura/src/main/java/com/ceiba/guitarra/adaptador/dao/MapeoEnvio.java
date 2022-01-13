package com.ceiba.guitarra.adaptador.dao;

import com.ceiba.guitarra.consulta.ManejadorObtenerEmpresa;
import com.ceiba.guitarra.consulta.ManejadorObtenerGuitarra;
import com.ceiba.guitarra.modelo.dto.DtoEmpresa;
import com.ceiba.guitarra.modelo.dto.DtoEnvio;
import com.ceiba.guitarra.modelo.dto.DtoGuitarra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoEnvio implements RowMapper<DtoEnvio>, MapperResult {

    private final ManejadorObtenerGuitarra manejadorGuitarra;
    private final ManejadorObtenerEmpresa manejadorEmpresa;

    public MapeoEnvio(ManejadorObtenerGuitarra manejadorGuitarra,
                      ManejadorObtenerEmpresa manejadorEmpresa) {
        this.manejadorGuitarra = manejadorGuitarra;
        this.manejadorEmpresa = manejadorEmpresa;
    }

    @Override
    public DtoEnvio mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        DtoGuitarra guitarra = generarDtoGuitarra(resultSet.getLong("id_guitarra"));
        DtoEmpresa empresa = generarDtoEmpresa(resultSet.getLong("id_empresa"));
        LocalDate fechaEnvio = extraerLocalDate(resultSet, "fecha_envio");
        Double valorTotal = resultSet.getDouble("valor_total");
        LocalDate fechaEntrega = extraerLocalDate(resultSet, "fecha_entrega");

        return new DtoEnvio(id,guitarra,empresa,fechaEnvio,fechaEntrega,valorTotal);
    }

    private DtoGuitarra generarDtoGuitarra(Long idGuitarra){
        return manejadorGuitarra.ejecutar(idGuitarra);
    }

    private DtoEmpresa generarDtoEmpresa(Long idEmpresa){
        return manejadorEmpresa.ejecutar(idEmpresa);
    }

}
