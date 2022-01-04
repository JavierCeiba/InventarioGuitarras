package com.ceiba.guitarra.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.guitarra.modelo.entidad.Guitarra;
import com.ceiba.guitarra.puerto.repositorio.RepositorioGuitarra;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioGuitarraH2 implements RepositorioGuitarra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="guitarra", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="guitarra", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="guitarra", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="guitarra", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioGuitarraH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Guitarra guitarra) {
        return this.customNamedParameterJdbcTemplate.crear(guitarra, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Guitarra guitarra) {
        this.customNamedParameterJdbcTemplate.actualizar(guitarra, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
