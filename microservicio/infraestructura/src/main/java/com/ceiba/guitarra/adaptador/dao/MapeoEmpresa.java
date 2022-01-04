package com.ceiba.guitarra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.guitarra.modelo.dto.DtoEmpresa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEmpresa implements RowMapper<DtoEmpresa>, MapperResult {

    @Override
    public DtoEmpresa mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String nit = resultSet.getString("nit");

        return new DtoEmpresa(id,nombre,nit);
    }

}
