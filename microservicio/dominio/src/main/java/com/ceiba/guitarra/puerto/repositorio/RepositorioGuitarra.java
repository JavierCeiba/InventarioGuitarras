package com.ceiba.guitarra.puerto.repositorio;

import com.ceiba.guitarra.modelo.entidad.Guitarra;

public interface RepositorioGuitarra {
    /**
     * Permite agregar una Guitarra al inventario
     * @param guitarra
     * @return el id generado
     */
    Long crear(Guitarra guitarra);

    /**
     * Permite actualizar una Guitarra del inventario
     * @param guitarra
     */
    void actualizar(Guitarra guitarra);

    /**
     * Permite eliminar una Guitarra del inventario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una Guitarra con un referencia excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
