package com.titocarlos.sistemaventa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.titocarlos.sistemaventa.model.entity.DetalleVenta;
import com.titocarlos.sistemaventa.model.entity.Venta;
import com.titocarlos.sistemaventa.service.ClienteService;
import com.titocarlos.sistemaventa.service.DetalleVentaService;
import com.titocarlos.sistemaventa.service.ProductoService;
import com.titocarlos.sistemaventa.service.VentaService;

@Controller
public class VentaController {

    private final ClienteService clienteService;
    private final ProductoService productoService;
    private final VentaService ventaService;
    private final DetalleVentaService  detalleVentaService;

    public VentaController(ClienteService clienteService, ProductoService productoService, VentaService ventaService,DetalleVentaService detalleVentaService) {
        this.clienteService = clienteService;
        this.productoService = productoService;
        this.ventaService = ventaService;
        this.detalleVentaService= detalleVentaService;
    }

    @GetMapping("/venta/all")
    public String getVentas(Model model) {
        List<Venta> ventas = ventaService.getFindAll();
        
        // Imprimir cada venta en la consola
        for (Venta venta : ventas) {
            System.out.println("Venta ID: " + venta.getId());
            System.out.println("Fecha: " + venta.getFecha());
            System.out.println("Cliente: " + venta.getCliente().getNombre());
            System.out.println("Detalle de Venta:");
            for (DetalleVenta detalle : venta.getVentaProductos()) {
                System.out.println("   Producto: " + detalle.getProducto().getNombre());
                System.out.println("   Cantidad: " + detalle.getCantidad());
                System.out.println("   Precio Unitario: " + detalle.getPrecioUnitario());
                System.out.println("   Total: " + (detalle.getCantidad() * detalle.getPrecioUnitario()));
            }
            System.out.println("------------------------------------");
        }
    
        model.addAttribute("ventas", ventas);
        return "venta/ventas";
    }
    




    @GetMapping("/venta/create")
    public String mostrarFormString(Model model) {
        model.addAttribute("clientes", clienteService.getClientes());
        model.addAttribute("productos", productoService.getAllProductos());
        return "venta/createVenta";
    }

    @PostMapping("/venta/add")
    public String addVenta(@RequestBody VentaRequest ventaRequest) {

        int idCliente = ventaRequest.getIdCliente();
        Venta venta= ventaService.crearVenta(clienteService.getCliente(idCliente));
        
        List<DetalleVentaRequest> detallesVenta = ventaRequest.getDetalleVenta();

        for (DetalleVentaRequest detalle : detallesVenta) {

         DetalleVenta detalleVenta = new DetalleVenta();
          detalleVenta.setProducto(productoService.getProducto(detalle.getId_producto()));
          detalleVenta.setVenta(ventaService.getVenta(venta.getId()));
          detalleVenta.setCantidad(detalle.getCantidad());
          detalleVenta.setPrecioUnitario(detalle.getPrecioUnitario());
       detalleVentaService.crearDetalle(venta, detalleVenta);

        }

        // Aquí puedes llamar al servicio para procesar la venta

        return "redirect:/venta/all";
    }

    @GetMapping("/venta/delete/{id}")
    public String deleteVenta(@PathVariable int id) {
        ventaService.deleteVenta(id);
        return "redirect:venta/all";
    }

    @GetMapping("/venta/edit/{id}")
    public String mostrarFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("venta", ventaService.getVenta(id));
        return "/venta/editVenta";
    }

    @PostMapping("/venta/update")
    public String updateVenta(@RequestBody Venta venta) {
        ventaService.updateVenta(venta);
        return "redirect:/venta/all";
    }
}
