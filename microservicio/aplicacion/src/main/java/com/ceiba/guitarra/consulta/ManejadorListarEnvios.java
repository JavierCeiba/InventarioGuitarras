package com.ceiba.guitarra.consulta;

import com.ceiba.guitarra.modelo.dto.DtoEnvio;
import com.ceiba.guitarra.puerto.dao.DaoEnvio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEnvios {

    private final DaoEnvio daoEnvio;

    public ManejadorListarEnvios(DaoEnvio daoEnvio){
        this.daoEnvio = daoEnvio;
    }

    public List<DtoEnvio> ejecutar(){ return this.daoEnvio.listar(); }
}
