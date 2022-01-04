package com.ceiba.guitarra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.guitarra.modelo.dto.DtoGuitarra;
import com.ceiba.guitarra.puerto.dao.DaoGuitarra;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoGuitarraH2 implements DaoGuitarra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="guitarra", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="guitarra", value="obtenerPorId")
    private static String sqlObtenerPorId;

    public DaoGuitarraH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoGuitarra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoGuitarra());
    }

    @Override
    public DtoGuitarra obtenerPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId, paramSource, new MapeoGuitarra());
    }
}
