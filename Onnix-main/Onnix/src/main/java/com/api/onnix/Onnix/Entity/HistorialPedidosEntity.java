package com.api.onnix.Onnix.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="Historial_Pedidos")
public class HistorialPedidosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Historial")
    private Long id;

    @NonNull
    @Column(name = "fecha_Pedido")
    private Date fechaPedido;

    @NonNull
    @Column(name = "estado")
    private String estado;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Usuario")
    private UsuariosEntity usuarios;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Pedido")
    private PedidosEntity pedidos;
}
