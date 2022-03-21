package com.tapitapp.tapitapp.model;

public class Precios {

    private Integer id;
    private String tipo;
    private Double cuantia;

    public Precios(Integer id, String tipo, Double cuantia) {
        this.id = id;
        this.tipo = tipo;
        this.cuantia = cuantia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCuantia() {
        return cuantia;
    }

    public void setCuantia(Double cuantia) {
        this.cuantia = cuantia;
    }

}
