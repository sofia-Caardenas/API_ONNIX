package com.api.onnix.Onnix.Repository;


import com.api.onnix.Onnix.Entity.UsuariosEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity,Long> {

    @Query(value = "select u from UsuariosEntity u where nombre like %:nombre%")
    List<UsuariosEntity> findAllByNombre(String nombre);

    @Query(value = "select u from UsuariosEntity u where email = :usuario and clave = :pass")
    List<UsuariosEntity> findAllByNombre(String usuario,String pass);

}
