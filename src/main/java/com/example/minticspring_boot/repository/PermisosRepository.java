package com.example.minticspring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisosRepository extends JpaRepository <Permisos, Long> {
}
