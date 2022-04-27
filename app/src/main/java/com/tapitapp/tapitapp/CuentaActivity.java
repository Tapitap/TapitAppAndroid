package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.tapitapp.tapitapp.db.conexionSQLiteHelper;
import com.tapitapp.tapitapp.db.utilidades;
import com.tapitapp.tapitapp.model.Comandas;
import com.tapitapp.tapitapp.model.Cuentas;
import com.tapitapp.tapitapp.model.LineaCuenta;
import com.tapitapp.tapitapp.util.AdapterComanda;
import com.tapitapp.tapitapp.util.AdapterCuenta;

import java.util.ArrayList;

public class CuentaActivity extends AppCompatActivity {
    ArrayList<LineaCuenta> ListLineaCuentas;
    ArrayList<Comandas> ListComanda_cuentas;
    RecyclerView recycler;

    conexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        conn=new conexionSQLiteHelper(getApplicationContext(),"Tapitapp.db",null,utilidades.VERSION);

        recycler =(RecyclerView) findViewById(R.id.ListCuenta);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        ListLineaCuentas=new ArrayList<>();

        consultarCuenta();

        AdapterCuenta adapter= new AdapterCuenta(ListLineaCuentas);


        recycler.setAdapter(adapter);


    }

    private void consultarCuenta() {
        SQLiteDatabase db = conn.getReadableDatabase();
        LineaCuenta LineaCuenta = null;

        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_LINEACUENTA, null);

        while (cursor.moveToNext()){

            LineaCuenta= new LineaCuenta();
            LineaCuenta.setId_lineaCuenta(cursor.getInt(0));
            LineaCuenta.setNombreLinea(cursor.getString(1));
            LineaCuenta.setCantidadLinea(cursor.getInt(2));
            LineaCuenta.setTotalCuenta(cursor.getDouble(3));

            ListLineaCuentas.add(LineaCuenta);
        }
    }
}