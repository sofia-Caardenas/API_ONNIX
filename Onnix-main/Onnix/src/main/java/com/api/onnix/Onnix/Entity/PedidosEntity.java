package com.api.onnix.Onnix.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="Pedidos")
public class PedidosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Pedido")
    private Long id;

    @NonNull
    @Column(name = "fecha_Pedido")
    private Date fechaPedido;

    @NonNull
    @Column(name = "estado")
    private String estado;

    @NonNull
    @Column(name = "total")
    private Double total;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Usuario")
    private UsuariosEntity usuarios;

}