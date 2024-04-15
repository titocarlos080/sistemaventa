package com.titocarlos.sistemaventa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titocarlos.sistemaventa.model.entity.Venta;

public interface VentaRepository  extends JpaRepository<Venta,Integer>{
    
}
