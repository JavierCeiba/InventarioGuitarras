package com.ceiba.guitarra.puerto.dao;

import com.ceiba.guitarra.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoUsuario {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoUsuario> listar();
}
