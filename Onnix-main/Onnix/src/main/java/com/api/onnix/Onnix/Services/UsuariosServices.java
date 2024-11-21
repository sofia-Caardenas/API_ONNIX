package com.api.onnix.Onnix.Services;

import com.api.onnix.Onnix.DTO.UsuariosDTO;

import java.util.List;

public interface UsuariosServices {

    List<UsuariosDTO> getUsuarios();

    List<UsuariosDTO> getUsuariosById(Long id);

    List<UsuariosDTO> getUsuariosByNombre(String nombre);

    boolean crearUsuario(UsuariosDTO usuariosDTO);

    boolean actualizarUsuario(UsuariosDTO usuariosDTO);

    List<UsuariosDTO> login(String usuario, String pass);
}
