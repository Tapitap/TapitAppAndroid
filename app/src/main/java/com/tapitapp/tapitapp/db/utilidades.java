package com.tapitapp.tapitapp.db;

import android.database.sqlite.SQLiteDatabase;

public class utilidades {


    //constantes campos tabla
    public static final String TABLA_LINEA="linea";
    public static final String IDLinea="id";
    public static final String IDComanda="id_comanda";
    public static final String IDProducto="id_producto";
    public static final String Precio="precio";
    public static final String Cantidad="cantidad";
    public static final String total="total";
    public static final String Nombre="nombre";


    public static final String CREAR_TABLA_LINEA="CREATE TABLE "+
            ""+TABLA_LINEA + "("+IDLinea+ " " +
            " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
            IDProducto+ " "+  "INTEGER , " +Nombre+" "+  "INTEGER, " +
            Precio+" "+  "INTEGER , "+  Cantidad+" "+  "INTEGER, " +
            total +" "+  "DOUBLE)";


}
