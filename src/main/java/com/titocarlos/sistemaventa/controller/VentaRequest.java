package com.titocarlos.sistemaventa.controller;

import java.util.List;

public class VentaRequest {
    private int idCliente;
    private List<DetalleVentaRequest> detalleVenta;
    public VentaRequest() {
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public List<DetalleVentaRequest> getDetalleVenta() {
        return detalleVenta;
    }
    public void setDetalleVenta(List<DetalleVentaRequest> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
    
}
