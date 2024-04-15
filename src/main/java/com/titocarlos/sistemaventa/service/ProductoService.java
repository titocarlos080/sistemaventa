package com.titocarlos.sistemaventa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.titocarlos.sistemaventa.model.dto.ProductoDto;
import com.titocarlos.sistemaventa.model.entity.Producto;
import com.titocarlos.sistemaventa.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDto> getAllProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void saveProducto(Producto producto) {

        productoRepository.save(producto);
    }

    public void updateProducto(Producto producto) {
        Optional<Producto> productoOptional = productoRepository.findById(producto.getId());
        if (productoOptional.isPresent()) {
            Producto productoExistente = productoOptional.get();
            // Actualizar los campos del cliente existente con los nuevos valores
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStock(producto.getStock());
            productoExistente.setCosto(producto.getCosto());

            // Guardar el cliente actualizado en la base de datos
            productoRepository.save(productoExistente);
        } else {
            // Manejar el caso en el que el cliente no existe
            throw new RuntimeException("Cliente no encontrado con ID: " + producto.getId());
        }
    }

    public Producto getProducto(int id){
        return productoRepository.getReferenceById(id);
    }
    public ProductoDto getProductoById(int id) {
        return convertToDTO(productoRepository.getReferenceById(id));
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

    private ProductoDto convertToDTO(Producto producto) {
        ProductoDto dto = new ProductoDto();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setStock(producto.getStock());
        dto.setPrecio(producto.getPrecio());
        return dto;
    }

}
