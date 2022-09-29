package com.example.minticspring_boot.repository;

import com.example.minticspring_boot.domain.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Long> {
}
