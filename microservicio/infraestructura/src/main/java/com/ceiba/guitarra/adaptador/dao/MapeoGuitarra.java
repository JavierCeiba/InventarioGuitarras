package com.ceiba.guitarra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.guitarra.modelo.dto.DtoGuitarra;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoGuitarra implements RowMapper<DtoGuitarra>, MapperResult {

    @Override
    public DtoGuitarra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String marca = resultSet.getString("marca");
        String tipo = resultSet.getString("tipo");
        String referencia = resultSet.getString("referencia");
        Double precio = resultSet.getDouble("precio");
        Boolean enviado = resultSet.getBoolean("enviado");

        return new DtoGuitarra(id,marca,tipo,referencia,precio,enviado);
    }

}
