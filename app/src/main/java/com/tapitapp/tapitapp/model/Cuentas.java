package com.tapitapp.tapitapp.model;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cuentas {

    private Integer id_cuenta;
    private Double total_cuenta;
    private LocalDateTime fecha;
    private Comandas id_comanda;

    public Cuentas(Integer id_cuenta, Double total_cuenta, LocalDateTime fecha, Comandas id_comanda) {
        this.id_cuenta = id_cuenta;
        this.total_cuenta = total_cuenta;
        this.fecha = fecha;
        this.id_comanda = id_comanda;
    }

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public Double getTotal_cuenta() {
        return total_cuenta;
    }

    public void setTotal_cuenta(Double total_cuenta) {
        this.total_cuenta = total_cuenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Comandas getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(Comandas id_comanda) {
        this.id_comanda = id_comanda;
    }
}
