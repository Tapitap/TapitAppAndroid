package com.tapitapp.tapitapp.db;

public class utilidades {

    //constantes campos tabla
    public static final String TABLA_LINEA="linea";
    public static final String IDLinea="id";
    public static final String IDComanda="id_comanda";
    public static final String IDProducto="id_producto";
    public static final String IDPrecio="id_precio";
    public static final String Cantidad="cantidad";

    public static final String CREAR_TABLA_LINEA="CREATE TABLE "+
            ""+TABLA_LINEA + "("+IDLinea+ " " +
            " INTEGER AUTOINCREMENT ,"+IDComanda+ " " +
            " INTEGER ,"+ IDProducto+ " "+  "INTEGER , " +
            IDPrecio+" "+  "INTEGER , "+
            Cantidad+" "+  "INTEGER)";
}
