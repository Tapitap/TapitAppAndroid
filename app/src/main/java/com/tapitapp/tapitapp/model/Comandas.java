package com.tapitapp.tapitapp.model;

import android.os.Parcelable;

public class Comandas  {

    private Integer id_comanda;
    private Integer id_producto;
    private Double id_precio;
    private Integer cantidad;
    private String nombre;
    private String tipo;
    private Double total;


    public Comandas() {
        this.id_comanda = id_comanda;
        this.id_producto = id_producto;
        this.id_precio = id_precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.tipo = tipo;
        this.total = total;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}