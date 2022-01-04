package com.ceiba.guitarra.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.guitarra.modelo.entidad.Envio;
import com.ceiba.guitarra.puerto.repositorio.RepositorioEnvio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEnvioH2 implements RepositorioEnvio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="envio", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="guitarra", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioEnvioH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Envio envio) {
        return this.customNamedParameterJdbcTemplate.crear(envio, sqlCrear);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }

}
