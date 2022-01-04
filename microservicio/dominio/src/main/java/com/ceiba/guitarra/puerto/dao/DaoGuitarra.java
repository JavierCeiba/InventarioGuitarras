package com.ceiba.guitarra.puerto.dao;

import com.ceiba.guitarra.modelo.dto.DtoGuitarra;

import java.util.List;

public interface DaoGuitarra {

    /**
     * Permite listar guitarras
     * @return las guitarras
     */
    List<DtoGuitarra> listar();

    /**
     * Permite obtener una guitarra por ID
     * @return la guitarra
     */
    DtoGuitarra obtenerPorId(Long id);
}
