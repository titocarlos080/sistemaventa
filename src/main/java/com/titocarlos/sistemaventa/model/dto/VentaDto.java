package com.titocarlos.sistemaventa.model.dto;

import java.util.Date;

public class VentaDto {
    public VentaDto() {
    }
    private int id;
    private Date fecha;
    private int id_cliente;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }  
}
