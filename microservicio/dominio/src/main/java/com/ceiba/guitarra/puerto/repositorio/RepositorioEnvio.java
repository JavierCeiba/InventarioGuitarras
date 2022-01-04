package com.ceiba.guitarra.puerto.repositorio;

import com.ceiba.guitarra.modelo.entidad.Envio;

public interface RepositorioEnvio {
    /**
     * Permite crear un envío
     * @param envio
     * @return si se creó o no
     */
    Long crear(Envio envio);
    /**
     * Permite validar si existe un Envio con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
