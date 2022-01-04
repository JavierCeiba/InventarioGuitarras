package com.ceiba.guitarra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.guitarra.consulta.ManejadorObtenerEmpresa;
import com.ceiba.guitarra.consulta.ManejadorObtenerGuitarra;
import com.ceiba.guitarra.modelo.dto.DtoEnvio;
import com.ceiba.guitarra.puerto.dao.DaoEnvio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEnvioH2 implements DaoEnvio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final ManejadorObtenerGuitarra manejadorGuitarra;
    private final ManejadorObtenerEmpresa manejadorEmpresa;

    @SqlStatement(namespace="envio", value="listar")
    private static String sqlListar;

    public DaoEnvioH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
                      ManejadorObtenerGuitarra manejadorGuitarra,
                      ManejadorObtenerEmpresa manejadorEmpresa) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.manejadorGuitarra = manejadorGuitarra;
        this.manejadorEmpresa = manejadorEmpresa;
    }

    @Override
    public List<DtoEnvio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListar, new MapeoEnvio(manejadorGuitarra, manejadorEmpresa));
    }
}
