package com.ceiba.guitarra.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.guitarra.modelo.entidad.Guitarra;
import com.ceiba.guitarra.puerto.repositorio.RepositorioGuitarra;


public class ServicioCrearGuitarra {

    private static final String LA_GUITARRA_YA_EXISTE_EN_EL_SISTEMA = "La guitarra ya existe en el sistema";

    private final RepositorioGuitarra repositorioGuitarra;

    public ServicioCrearGuitarra(RepositorioGuitarra repositorioGuitarra) {
        this.repositorioGuitarra = repositorioGuitarra;
    }

    public Long ejecutar(Guitarra guitarra) {
        validarExistenciaPrevia(guitarra);
        return this.repositorioGuitarra.crear(guitarra);
    }

    private void validarExistenciaPrevia(Guitarra guitarra) {
        boolean existe = this.repositorioGuitarra.existePorId(guitarra.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_GUITARRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
