package com.ceiba.guitarra.puerto.dao;

import com.ceiba.guitarra.modelo.dto.DtoEmpresa;

import java.util.List;

public interface DaoEmpresa {

    /**
     * Permite listar guitarras
     * @return las guitarras
     */
    List<DtoEmpresa> listar();

    /**
     * Permite obtener una guitarra por ID
     * @return la guitarra
     */
    DtoEmpresa obtenerPorId(Long id);
}
