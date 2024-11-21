package com.api.onnix.Onnix.Services;

import com.api.onnix.Onnix.DTO.ContactosDTO;
import com.api.onnix.Onnix.DTO.UsuariosDTO;

import java.util.List;

public interface ContactosServices {

    List<ContactosDTO> getContactosByIdUsuario(Long id);

    boolean crearContactos(ContactosDTO contactosDTO);

    boolean actualizarContactos(ContactosDTO datosNew);
}
