package com.api.onnix.Onnix.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductosDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Long stock;
    private Date fechaAgregado;
    private String rutaImagen;
    private String estado;

}
