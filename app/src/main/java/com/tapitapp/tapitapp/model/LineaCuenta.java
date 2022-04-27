package com.tapitapp.tapitapp.model;

import java.time.LocalDateTime;

public class LineaCuenta {

    private Integer id_lineaCuenta;
    private String nombreLinea;
    private Integer cantidadLinea;
    private Double totalCuenta;


    public LineaCuenta() {
        this.id_lineaCuenta = id_lineaCuenta;
        this.nombreLinea = nombreLinea;
        this.cantidadLinea = cantidadLinea;
        this.totalCuenta = totalCuenta;
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

    public Double getTotalCuenta() {
        return totalCuenta;
    }

    public void setTotalCuenta(Double totalCuenta) {
        this.totalCuenta = totalCuenta;
    }
}
