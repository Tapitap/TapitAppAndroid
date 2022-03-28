package com.tapitapp.tapitapp.model;

import android.graphics.Bitmap;

import java.util.List;

public class Productos {
    private Integer id,idManager;
    private String nombre ,descripcion,tipo;
    private List<Precios> precios;
    private boolean oferta;
    private Bitmap ico;


    public Productos(Integer id, Integer idManager, String nombre, String descripcion, String tipo, List<Precios> precios, boolean oferta) {
        this.id = id;
        this.idManager = idManager;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precios = precios;
        this.oferta = oferta;
    }

    public Integer getId() {
        return id;
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

    public List<Precios> getPrecios() {return precios;}

    public boolean getOferta() {
        return oferta;
    }

    public Bitmap getIco(){ return ico; }

    public void setId(Integer id) {
        this.id = id;
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

    public void setPrecios(List<Precios> precios){this.precios = precios;}

    public void setOferta(boolean oferta) {
        this.oferta = oferta;
    }

    public void setIco(Bitmap ico){this.ico = ico;}
}
