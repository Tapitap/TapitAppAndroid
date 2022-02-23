package com.tapitapp.tapitapp.model;

public class Productos {
    private Integer idManager,idProducto;
    private String nombre ,descripcion,tipo,tipoPlato;
    private Double precio;


    public Productos(Integer idManager, Integer idProducto, String nombre, String descripcion, String tipo, String tipoPlato, Double precio) {
        this.idManager = idManager;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.tipoPlato = tipoPlato;
        this.precio = precio;
    }

    public Integer getIdManager() {
        return idManager;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTipoPlato() {
        return tipoPlato;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
