package com.ceiba.guitarra.comando.fabrica;

import com.ceiba.guitarra.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

import com.ceiba.guitarra.comando.ComandoUsuario;

@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario) {
        return new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getNombre(),
                comandoUsuario.getClave(),
                comandoUsuario.getFecha()
        );
    }

}
