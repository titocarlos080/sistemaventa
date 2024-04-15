package com.titocarlos.sistemaventa.model.dto;

public class ProductoDto {
    private int id;
    private String nombre;
    private Integer stock;
    private Float precio;

    public ProductoDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    // Getters y Setters (omitiendo para brevedad)
}
