package com.ceiba.guitarra.consulta;

import com.ceiba.guitarra.modelo.dto.DtoEmpresa;
import com.ceiba.guitarra.puerto.dao.DaoEmpresa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEmpresas {

    private final DaoEmpresa daoEmpresa;

    public ManejadorListarEmpresas(DaoEmpresa daoEmpresa){
        this.daoEmpresa = daoEmpresa;
    }

    public List<DtoEmpresa> ejecutar(){ return this.daoEmpresa.listar(); }
}
