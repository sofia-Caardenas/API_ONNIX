package com.api.onnix.Onnix.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="Productos")
public class ProductosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Producto")
    private Long id;

    @NonNull
    @Column(name = "nombre")
    private String nombre;

    @NonNull
    @Column(name = "descripcion")
    private String descripcion;

    @NonNull
    @Column(name = "precio")
    private Double precio;

    @NonNull
    @Column(name = "stock")
    private Long stock;

    @NonNull
    @Column(name = "fecha_Agregado")
    private Date fechaAgregado;

    @Column(name = "ruta_Imagen")
    private String rutaImagen;

    @NonNull
    @Column(name = "estado")
    private String estado;

}
