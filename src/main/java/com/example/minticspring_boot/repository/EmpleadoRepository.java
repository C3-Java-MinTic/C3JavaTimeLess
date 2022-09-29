package com.example.minticspring_boot.repository;

import com.example.minticspring_boot.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleado, Long> {
}

