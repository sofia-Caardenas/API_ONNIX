package com.api.onnix.Onnix.Mapper;

import com.api.onnix.Onnix.DTO.ContactosDTO;
import com.api.onnix.Onnix.DTO.UsuariosDTO;
import com.api.onnix.Onnix.Entity.ContactosEntity;
import com.api.onnix.Onnix.Entity.UsuariosEntity;

public class ContactosMapper {

    // Convierte de Entidad a DTO
    public static ContactosDTO toContactosDTO(ContactosEntity contactos) {
        ContactosDTO contactosDTO = new ContactosDTO();
        contactosDTO.setId(contactos.getId());
        contactosDTO.setTelefono1(contactos.getTelefono1());
        contactosDTO.setTelefono2(contactos.getTelefono2());
        contactosDTO.setDireccion(contactos.getDireccion());
        contactosDTO.setEstado(contactos.getEstado());
        UsuariosDTO usuariosDTO = new UsuariosDTO();
        usuariosDTO.setId(contactos.getUsuarios().getId());
        contactosDTO.setUsuarios(usuariosDTO);
        return contactosDTO;
    }

    // Convierte de DTO a Entidad
    public static ContactosEntity toContactosEntity(ContactosDTO contactosDTO) {
        ContactosEntity contactos = new ContactosEntity();
        contactos.setTelefono1(contactosDTO.getTelefono1());
        contactos.setTelefono2(contactosDTO.getTelefono2());
        contactos.setDireccion(contactosDTO.getDireccion());
        contactos.setEstado(contactosDTO.getEstado());
        UsuariosEntity usuarios = new UsuariosEntity();
        usuarios.setId(contactosDTO.getUsuarios().getId());
        contactos.setUsuarios(usuarios);
        return contactos;
    }

}
