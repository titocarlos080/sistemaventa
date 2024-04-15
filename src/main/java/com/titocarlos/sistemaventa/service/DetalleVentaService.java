package com.titocarlos.sistemaventa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.titocarlos.sistemaventa.model.entity.DetalleVenta;
import com.titocarlos.sistemaventa.model.entity.Venta;
import com.titocarlos.sistemaventa.repository.DetalleVentaRepository;

@Service
public class DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    public void crearDetalle(Venta venta, DetalleVenta detalleVenta) {

        detalleVenta.setVenta(venta);
        detalleVentaRepository.save(detalleVenta);

    }

    public  List<DetalleVenta> getDetalleVentas(){
         return detalleVentaRepository.findAll();
    }

}
