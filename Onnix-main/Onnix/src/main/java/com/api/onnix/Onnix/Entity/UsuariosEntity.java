package com.api.onnix.Onnix.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name="Usuarios")
public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_Usuario")
    private Long id;

    @NonNull
    @Column(name = "nombre")
    private String nombre;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "clave")
    private String clave;

    @NonNull
    @Column(name = "estado")
    private String estado;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_Rol")
    private RolesEntity roles;

}
