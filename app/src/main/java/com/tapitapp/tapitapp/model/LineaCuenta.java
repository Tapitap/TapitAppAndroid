package com.tapitapp.tapitapp.model;

import com.tapitapp.tapitapp.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;

public class LineaCuenta {

    private int id_lineaCuenta;
    private String nombreLinea;
    private int cantidadLinea;
    private double precioLinea;
    private double total;


    public LineaCuenta() {
        this.id_lineaCuenta = id_lineaCuenta;
        this.nombreLinea = nombreLinea;
        this.cantidadLinea = cantidadLinea;
        this.precioLinea = precioLinea;
        this.total = total;
    }

    public LineaCuenta(JSONObject json) throws JSONException {
        this.id_lineaCuenta = json.has("id")?(json.isNull("id")?id_lineaCuenta:json.getInt("id")):id_lineaCuenta;
        this.nombreLinea = json.has("nombre")?(json.isNull("nombre")?null:json.getString("nombre")):null;
        this.cantidadLinea = json.has("cantidad")? json.isNull("cantidad")?cantidadLinea:json.getInt("cantidad"):cantidadLinea;
        this.precioLinea = json.has("cuantia")?(json.isNull("cuantia")?precioLinea:json.getDouble("cuantia")):precioLinea;
        this.total = Util.MultRound(this.precioLinea*this.cantidadLinea,2);
    }

    public Integer getId_lineaCuenta() {
        return id_lineaCuenta;
    }

    public void setId_lineaCuenta(Integer id_lineaCuenta) {
        this.id_lineaCuenta = id_lineaCuenta;
    }

    public String getNombreLinea() {
        return nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public Integer getCantidadLinea() {
        return cantidadLinea;
    }

    public void setCantidadLinea(Integer cantidadLinea) {
        this.cantidadLinea = cantidadLinea;
    }

    public Double getPrecioLinea() {
        return precioLinea;
    }

    public void setPrecioLinea(Double precioLinea) {
        this.precioLinea = precioLinea;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
