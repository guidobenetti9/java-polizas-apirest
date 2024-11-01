package com.TrabajoPolizas.Polizas.repository;

import com.TrabajoPolizas.Polizas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
