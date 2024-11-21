package com.api.onnix.Onnix.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistorialPedidosDTO {

    private Long id;
    private Date fechaPedido;
    private String estado;
    private UsuariosDTO usuarios;
    private PedidosDTO pedidos;

}
