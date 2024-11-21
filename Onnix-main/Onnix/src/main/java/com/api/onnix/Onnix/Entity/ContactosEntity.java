package com.api.onnix.Onnix.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name="Contacto")
public class ContactosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Contacto")
    private Long id;

    @NonNull
    @Column(name = "telefono1")
    private String telefono1;

    @Column(name = "telefono2")
    private String telefono2;

    @NonNull
    @Column(name = "direccion")
    private String direccion;

    @NonNull
    @Column(name = "estado")
    private String estado;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Usuario")
    private UsuariosEntity usuarios;

}
