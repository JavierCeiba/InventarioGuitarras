package com.ceiba.guitarra.consulta;

import com.ceiba.guitarra.modelo.dto.DtoEmpresa;
import com.ceiba.guitarra.puerto.dao.DaoEmpresa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerEmpresa {

    private final DaoEmpresa daoEmpresa;

    public ManejadorObtenerEmpresa(DaoEmpresa daoEmpresa){
        this.daoEmpresa = daoEmpresa;
    }

    public DtoEmpresa ejecutar(Long idEmpresa){ return this.daoEmpresa.obtenerPorId(idEmpresa); }
}
