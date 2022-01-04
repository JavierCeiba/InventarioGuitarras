package com.ceiba.guitarra.consulta;

import com.ceiba.guitarra.modelo.dto.DtoGuitarra;
import com.ceiba.guitarra.puerto.dao.DaoGuitarra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarGuitarras {

    private final DaoGuitarra daoGuitarra;

    public ManejadorListarGuitarras(DaoGuitarra daoGuitarra){
        this.daoGuitarra = daoGuitarra;
    }

    public List<DtoGuitarra> ejecutar(){ return this.daoGuitarra.listar(); }
}
