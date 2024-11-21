package com.api.onnix.Onnix.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidosDTO {

    private Long id;
    private Date fechaPedido;
    private String estado;
    private Double total;
    private UsuariosDTO usuarios;

}
