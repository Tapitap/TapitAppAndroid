package com.tapitapp.tapitapp.model;

public class Comandas {

    private Integer id_comanda;
    private Integer id_producto;
    private Double id_precio;
    private Integer cantidad;
    private Double Total;


    public Comandas(Integer id_comanda, Integer id_producto, Double id_precio, Integer cantidad, Double total) {
        this.id_comanda = id_comanda;
        this.id_producto = id_producto;
        this.id_precio = id_precio;
        this.cantidad = cantidad;
        Total = total;
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

    public Double getId_precio() {
        return id_precio;
    }

    public void setId_precio(Double id_precio) {
        this.id_precio = id_precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }
}
