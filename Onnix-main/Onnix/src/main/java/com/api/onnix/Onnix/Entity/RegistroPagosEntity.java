package com.api.onnix.Onnix.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="Registro_Pagos")
public class RegistroPagosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Pago")
    private Long id;

    @NonNull
    @Column(name = "metodo_Pago")
    private String metodoPago;

    @NonNull
    @Column(name = "fecha_Pago")
    private Date fechaPago;

    @NonNull
    @Column(name = "monto")
    private Double monto;

    @NonNull
    @Column(name = "detalle_Registro")
    private String detalleRegistro;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Pedido")
    private PedidosEntity pedido;
}
