package com.api.onnix.Onnix.Repository;


import com.api.onnix.Onnix.Entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntity,Long> {

    @Query(value = "select p from ProductosEntity p where nombre like %:nombre%")
    List<ProductosEntity> findAllByNombre(String nombre);


}
