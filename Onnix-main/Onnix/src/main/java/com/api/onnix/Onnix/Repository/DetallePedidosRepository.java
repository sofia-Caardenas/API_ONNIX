package com.api.onnix.Onnix.Repository;


import com.api.onnix.Onnix.Entity.DetallePedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidosRepository extends JpaRepository<DetallePedidosEntity,Long> {

    @Query(value = "select u from DetallePedidosEntity u " +
            "where u.pedidos.estado != 'Entregado'")
    List<DetallePedidosEntity> findAllBySinEntregar();

    @Query(value = "select u from DetallePedidosEntity u " +
            "where u.pedidos.estado != 'Entregado' and u.pedidos.usuarios.id = :idCliente")
    List<DetallePedidosEntity> findAllBySinEntregarCliente(Long idCliente);

    @Query(value = "select u from DetallePedidosEntity u " +
            "where u.pedidos.usuarios.id = :idCliente")
    List<DetallePedidosEntity> findAllByCliente(Long idCliente);

}
