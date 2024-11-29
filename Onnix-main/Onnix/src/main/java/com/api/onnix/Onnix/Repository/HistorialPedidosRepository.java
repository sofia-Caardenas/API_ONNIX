package com.api.onnix.Onnix.Repository;

import com.api.onnix.Onnix.Entity.HistorialPedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialPedidosRepository extends JpaRepository<HistorialPedidosEntity,Long> {

    @Query(value = "select u from HistorialPedidosEntity u " +
            "where u.estado != 'Entregado'")
    List<HistorialPedidosEntity> findAllBySinEntregar();

    @Query(value = "select u from HistorialPedidosEntity u " +
            "where u.estado != 'Entregado' and u.pedidos.usuarios.id = :idCliente")
    List<HistorialPedidosEntity> findAllBySinEntregarCliente(Long idCliente);

    @Query(value = "select u from HistorialPedidosEntity u " +
            "where u.pedidos.usuarios.id = :idCliente")
    List<HistorialPedidosEntity> findAllByCliente(Long idCliente);

}
