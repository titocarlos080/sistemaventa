package com.titocarlos.sistemaventa.controller;

 
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.titocarlos.sistemaventa.model.dto.ProductoDto;
import com.titocarlos.sistemaventa.model.entity.Producto;
import com.titocarlos.sistemaventa.service.ProductoService;

import java.util.List;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/producto/all")
    public String getProductos(Model model) {
        List<ProductoDto> productos = productoService.getAllProductos();
        model.addAttribute("productos", productos);
        return "producto/productos";
    }

    @GetMapping("/producto/create")
    public String showCreateForm() {

        return "producto/createProducto";
    }

    @PostMapping("/producto/create")
    public String createProducto(@RequestBody  Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/producto/all";
    }

    @GetMapping("/producto/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Producto Producto = productoService.getProducto(id);
        model.addAttribute("producto", Producto);
        return "producto/editProducto";
    }

    @PostMapping("/producto/edit")
    public String updateProducto(@RequestBody  Producto producto) {
      
        productoService.saveProducto(producto);
        return "redirect:/producto/all";
    }

    @GetMapping("/producto/delete/{id}")
    public String deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
        return "redirect:/producto/all";
    }
}
