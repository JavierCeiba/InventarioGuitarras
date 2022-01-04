package com.ceiba.guitarra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.guitarra.modelo.dto.DtoEmpresa;
import com.ceiba.guitarra.puerto.dao.DaoEmpresa;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEmpresaH2 implements DaoEmpresa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="empresa", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="empresa", value="obtenerPorId")
    private static String sqlObtenerPorId;

    public DaoEmpresaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEmpresa> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEmpresa());
    }

    @Override
    public DtoEmpresa obtenerPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId, paramSource, new MapeoEmpresa());
    }
}
