package com.api.onnix.Onnix.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetallePedidosDTO {

    private Long id;
    private Long cantidad;
    private Double precio;
    private Double subtotal;
    private PedidosDTO pedidos;
    private ProductosDTO productos;

}
