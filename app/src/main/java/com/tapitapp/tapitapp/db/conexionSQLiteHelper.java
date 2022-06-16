package com.tapitapp.tapitapp.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.tapitapp.tapitapp.model.Comandas;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class conexionSQLiteHelper extends SQLiteOpenHelper {




    public conexionSQLiteHelper( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(utilidades.CREAR_TABLA_LINEA);
       //sqLiteDatabase.execSQL(utilidades.CREAR_TABLA_Cuentas);
       sqLiteDatabase.execSQL(utilidades.CREAR_TABLA_LINEACUENTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(utilidades.DELETE_TABLA_LINEA);
        //sqLiteDatabase.execSQL(utilidades.DELETE_TABLA_CUENTAS);
        sqLiteDatabase.execSQL(utilidades.DELETE_TABLA_LINEACUENTA);

        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TABLA_LINEA");
        onCreate(sqLiteDatabase);

    }


}
