package com.titocarlos.sistemaventa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titocarlos.sistemaventa.model.entity.DetalleVenta;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Integer> {
    
}
