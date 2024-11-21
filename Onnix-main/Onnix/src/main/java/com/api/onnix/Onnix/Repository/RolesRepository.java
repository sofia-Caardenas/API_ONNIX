package com.api.onnix.Onnix.Repository;


import com.api.onnix.Onnix.Entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity,Long> {
}
