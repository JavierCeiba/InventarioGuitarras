package com.ceiba.guitarra.puerto.dao;

import com.ceiba.guitarra.modelo.dto.DtoEnvio;

import java.util.List;

public interface DaoEnvio {

    /**
     * Permite listar envíos
     * @return los envíos
     */
    List<DtoEnvio> listar();
}
