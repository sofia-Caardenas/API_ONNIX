package com.api.onnix.Onnix.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name="Detalles_Pedidos")
public class DetallePedidosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Detalle")
    private Long id;

    @NonNull
    @Column(name = "cantidad")
    private Long cantidad;

    @NonNull
    @Column(name = "precio")
    private Double precio;

    @NonNull
    @Column(name = "subtotal")
    private Double subtotal;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Pedido")
    private PedidosEntity pedidos;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Producto")
    private ProductosEntity productos;

}
