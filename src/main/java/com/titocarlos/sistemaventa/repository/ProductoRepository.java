package com.titocarlos.sistemaventa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titocarlos.sistemaventa.model.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
}
