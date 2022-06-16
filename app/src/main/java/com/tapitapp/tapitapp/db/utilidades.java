package com.tapitapp.tapitapp.db;

import android.database.sqlite.SQLiteDatabase;

public class utilidades {

    public static final Integer VERSION =3;

    //constantes campos tabla
    public static final String TABLA_LINEA="linea";
    public static final String TABLA_Cuenta="cuenta";
    public static final String TABLA_LINEACUENTA="lineaCuenta";
    public static final String IDLinea="id";
    public static final String IDCuenta="id_Cuenta";
    public static final String IDComanda="id_comanda";
    public static final String IDLineaCuenta="id_LineaCuenta";
    public static final String IDProducto="id_producto";
    public static final String Precio="precio";
    public static final String Cantidad="cantidad";
    public static final String total="total";
    public static final String total_cuenta="total_cuenta";
    public static final String fecha="fecha";
    public static final String Nombre="nombre";
    public static final String NombreCuenta="NombreCuenta";
    public static final String totalCuenta="totalCuenta";
    public static final String CantidadCuenta="CantidadCuenta";


    public static final String CREAR_TABLA_LINEA="CREATE TABLE "+
            ""+TABLA_LINEA + "("+IDLinea+ " " +
            " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
            IDProducto+ " "+  "INTEGER , " +Nombre+" "+  "INTEGER, " +
            Precio+" "+  "INTEGER , "+  Cantidad+" "+  "INTEGER, " +
            total +" "+  "DOUBLE)";

    public static final String DELETE_TABLA_LINEA =
            "DROP TABLE IF EXISTS " + TABLA_LINEA;

    /*public static final String CREAR_TABLA_Cuentas="CREATE TABLE "+
            ""+TABLA_Cuenta + "("+IDCuenta+ " " +
            " INTEGER PRIMARY KEY AUTOINCREMENT ," +total_cuenta+" "+  "DOUBLE, " +
            fecha+" "+  "TIMESTAMP ,)";

    public static final String DELETE_TABLA_CUENTAS =
            "DROP TABLE IF EXISTS " + TABLA_Cuenta;*/

    public static final String CREAR_TABLA_LINEACUENTA="CREATE TABLE "+
            ""+TABLA_LINEACUENTA + "("+IDLineaCuenta+ " " +
            " INTEGER PRIMARY KEY AUTOINCREMENT ,"+ NombreCuenta+" "+  "INTEGER, " + CantidadCuenta+" "+  "INTEGER, " + totalCuenta +" "+  "DOUBLE)";

    public static final String DELETE_TABLA_LINEACUENTA =
            "DROP TABLE IF EXISTS " + TABLA_LINEACUENTA;
}
