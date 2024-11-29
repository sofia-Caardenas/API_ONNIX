package com.api.onnix.Onnix.Mapper;

import com.api.onnix.Onnix.DTO.RolesDTO;
import com.api.onnix.Onnix.DTO.UsuariosDTO;
import com.api.onnix.Onnix.Entity.RolesEntity;
import com.api.onnix.Onnix.Entity.UsuariosEntity;

public class UsuariosMapper {

    // Convierte de Entidad a DTO
    public static UsuariosDTO toUsuariosDTO(UsuariosEntity user) {
        UsuariosDTO usuariosDTO = new UsuariosDTO();
        usuariosDTO.setId(user.getId());
        usuariosDTO.setNombre(user.getNombre());
        usuariosDTO.setEmail(user.getEmail());
        usuariosDTO.setEstado(user.getEstado());
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setId(user.getRoles().getId());
        rolesDTO.setNombre(user.getRoles().getNombre());
        rolesDTO.setEstado(user.getRoles().getEstado());
        usuariosDTO.setRoles(rolesDTO);
        return usuariosDTO;
    }

    public static UsuariosDTO toUsuariosDTOUpdate(UsuariosEntity user) {
        UsuariosDTO usuariosDTO = new UsuariosDTO();
        usuariosDTO.setId(user.getId());
        usuariosDTO.setNombre(user.getNombre());
        usuariosDTO.setEmail(user.getEmail());
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setId(user.getRoles().getId());
        rolesDTO.setNombre(user.getRoles().getNombre());
        rolesDTO.setEstado(user.getRoles().getEstado());
        usuariosDTO.setRoles(rolesDTO);
        return usuariosDTO;
    }

    // Convierte de DTO a Entidad
    public static UsuariosEntity toUsuariosEntity(UsuariosDTO usuariosDTO) {
        UsuariosEntity user = new UsuariosEntity();
        user.setNombre(usuariosDTO.getNombre());
        user.setEmail(usuariosDTO.getEmail());
        user.setClave(usuariosDTO.getClave());
        user.setEstado(usuariosDTO.getEstado());
        RolesEntity roles = new RolesEntity();
        roles.setId(usuariosDTO.getRoles().getId());
        user.setRoles(roles);
        return user;
    }

}
