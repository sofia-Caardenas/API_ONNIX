package com.api.onnix.Onnix.Repository;


import com.api.onnix.Onnix.Entity.ContactosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactosRepository extends JpaRepository<ContactosEntity,Long> {

    @Query(value = "select p from ContactosEntity p where p.usuarios.id = :idUsuario")
    List<ContactosEntity> findAllByIdUsuario(Long idUsuario);

}
