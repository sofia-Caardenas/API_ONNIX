package com.api.onnix.Onnix.Repository;


import com.api.onnix.Onnix.Entity.RegistroPagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroPagosRepository extends JpaRepository<RegistroPagosEntity,Long> {
}
