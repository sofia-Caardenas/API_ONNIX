package com.api.onnix.Onnix.Repository;


import com.api.onnix.Onnix.Entity.PedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<PedidosEntity,Long> {

}
