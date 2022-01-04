package com.ceiba.guitarra.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.guitarra.modelo.entidad.Envio;
import com.ceiba.guitarra.puerto.repositorio.RepositorioEnvio;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class ServicioCrearEnvio {

    private static final String EL_ENVIO_YA_EXISTE_EN_EL_SISTEMA = "El envio ya existe en el sistema";
    private static final String FECHA_DE_ENVIO_INVALIDA = "La fecha de envio no puede ser fines de semana";

    private final RepositorioEnvio repositorioEnvio;

    public ServicioCrearEnvio(RepositorioEnvio repositorioEnvio) {
        this.repositorioEnvio = repositorioEnvio;
    }

    public Long ejecutar(Envio envio){
        validarExistenciaPrevia(envio);
        validarEnvios(envio);
        validarDescuento(envio);
        generarFechaEntrega(envio);
        return this.repositorioEnvio.crear(envio);
    }

    private void validarExistenciaPrevia(Envio envio) {
        boolean existe = this.repositorioEnvio.existePorId(envio.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_ENVIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarEnvios(Envio envio) {
        if (envio.getFechaEnvío().getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                envio.getFechaEnvío().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            throw new ExcepcionValorInvalido(FECHA_DE_ENVIO_INVALIDA);
        }
    }

    private void validarDescuento(Envio envio){
        if (envio.getFechaEnvío().getDayOfWeek().equals(DayOfWeek.TUESDAY)){
            envio.setValorTotal(envio.getValorTotal()*.95);
        }
    }

    private void generarFechaEntrega(Envio envio){
        int diasEntrega = 3;
        LocalDate fechaEntrega = LocalDate.from(envio.getFechaEnvío());
        do {
            fechaEntrega = fechaEntrega.plusDays(1);
            if (!fechaEntrega.getDayOfWeek().equals(DayOfWeek.SATURDAY) &&
                    !fechaEntrega.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                --diasEntrega;
            }
        } while (diasEntrega != 0);
        envio.setFechaEntrega(fechaEntrega);
    }


}
