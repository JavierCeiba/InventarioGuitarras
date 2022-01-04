package com.ceiba.guitarra.consulta;

import java.util.List;

import com.ceiba.guitarra.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.guitarra.modelo.dto.DtoUsuario;

@Component
public class ManejadorListarUsuarios {

    private final DaoUsuario daoUsuario;

    public ManejadorListarUsuarios(DaoUsuario daoUsuario){
        this.daoUsuario = daoUsuario;
    }

    public List<DtoUsuario> ejecutar(){ return this.daoUsuario.listar(); }
}
