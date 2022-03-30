package com.tapitapp.tapitapp.model;

public class Comandas {

    private Integer id_comanda;
    private Integer id_producto;
    private Integer id_precio;
    private Integer cantidad;

    public Comandas(Integer id_comanda, Integer id_producto, Integer id_precio, Integer cantidad) {
        this.id_comanda = id_comanda;
        this.id_producto = id_producto;
        this.id_precio = id_precio;
        this.cantidad = cantidad;
    }

    public Integer getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(Integer id_comanda) {
        this.id_comanda = id_comanda;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getId_precio() {
        return id_precio;
    }

    public void setId_precio(Integer id_precio) {
        this.id_precio = id_precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
