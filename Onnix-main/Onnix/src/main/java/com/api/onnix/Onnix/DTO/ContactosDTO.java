package com.api.onnix.Onnix.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactosDTO {

    private Long id;
    private String telefono1;
    private String telefono2;
    private String direccion;
    private String estado;
    private UsuariosDTO usuarios;

}
