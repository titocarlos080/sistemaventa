package com.titocarlos.sistemaventa.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.titocarlos.sistemaventa.model.dto.VentaDto;
import com.titocarlos.sistemaventa.model.entity.Cliente;
import com.titocarlos.sistemaventa.model.entity.DetalleVenta;
import com.titocarlos.sistemaventa.model.entity.Venta;
import com.titocarlos.sistemaventa.repository.DetalleVentaRepository;
import com.titocarlos.sistemaventa.repository.VentaRepository;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;

    
    public VentaService(VentaRepository ventaRepository, DetalleVentaRepository detalleVentaRepository) {
        this.ventaRepository = ventaRepository;
        this.detalleVentaRepository = detalleVentaRepository;
    }

    public List<VentaDto> getAllVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

    }

    public List<Venta> getFindAll(){
        return ventaRepository.findAll();
    }

    private VentaDto convertToDTO(Venta venta) {
        VentaDto dto = new VentaDto();
        dto.setId(venta.getId());
        dto.setFecha(venta.getFecha());

        return dto;
    }
    public Venta crearVenta(Cliente cliente){
        Venta venta= new Venta();
        venta.setCliente(cliente);
        venta.setFecha(new Date());
      return ventaRepository.save(venta);
    }
    public void addVenta(Venta venta, List<DetalleVenta> listaDetalleVentas) {
        ventaRepository.save(venta);

        for (DetalleVenta detalleVenta : listaDetalleVentas) {

            detalleVentaRepository.save(detalleVenta);
        }
    }

    public void deleteVenta(int id) {
        ventaRepository.deleteById(id);

    }

   

    public void updateVenta(Venta venta) {
        Optional<Venta> ventaOptional = ventaRepository.findById(venta.getId());
        if (ventaOptional.isPresent()) {
            Venta ventaExistente = ventaOptional.get();
            // Actualizar los campos del cliente existente con los nuevos valores
            ventaExistente.setFecha(venta.getFecha());
             // Guardar el cliente actualizado en la base de datos
            ventaRepository.save(ventaExistente);
        } else {
            // Manejar el caso en el que el cliente no existe
            throw new RuntimeException("Cliente no encontrado con ID: " + venta.getId());
        }
    }

    public Venta getVenta(int id) {
         
      return  ventaRepository.getReferenceById(id);
    }

}
