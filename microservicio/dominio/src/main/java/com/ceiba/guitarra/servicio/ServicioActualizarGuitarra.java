package com.ceiba.guitarra.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.guitarra.modelo.entidad.Guitarra;
import com.ceiba.guitarra.puerto.repositorio.RepositorioGuitarra;

public class ServicioActualizarGuitarra {

    private static final String LA_GUITARRA_NO_EXISTE_EN_EL_SISTEMA = "La guitarra no existe en el sistema";

    private final RepositorioGuitarra repositorioGuitarra;

    public ServicioActualizarGuitarra(RepositorioGuitarra repositorioGuitarra) {
        this.repositorioGuitarra = repositorioGuitarra;
    }

    public void ejecutar(Guitarra guitarra) {
        validarExistenciaPrevia(guitarra);
        this.repositorioGuitarra.actualizar(guitarra);
    }

    private void validarExistenciaPrevia(Guitarra guitarra) {
        boolean existe = this.repositorioGuitarra.existePorId(guitarra.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_GUITARRA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
