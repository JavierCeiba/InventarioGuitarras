package com.ceiba.guitarra.consulta;

import com.ceiba.guitarra.modelo.dto.DtoGuitarra;
import com.ceiba.guitarra.puerto.dao.DaoGuitarra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerGuitarra {

    private final DaoGuitarra daoGuitarra;

    public ManejadorObtenerGuitarra(DaoGuitarra daoGuitarra){
        this.daoGuitarra = daoGuitarra;
    }

    public DtoGuitarra ejecutar(Long idGuitarra){ return this.daoGuitarra.obtenerPorId(idGuitarra); }
}
