package com.TrabajoPolizas.Polizas.repository;

import com.TrabajoPolizas.Polizas.model.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolizaRepository extends JpaRepository <Poliza, Long> {
    List<Poliza>findByNombreAsesor(String name);
}
