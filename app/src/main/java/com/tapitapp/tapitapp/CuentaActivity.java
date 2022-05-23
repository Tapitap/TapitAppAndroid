package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tapitapp.tapitapp.db.conexionSQLiteHelper;
import com.tapitapp.tapitapp.db.utilidades;
import com.tapitapp.tapitapp.model.Comandas;
import com.tapitapp.tapitapp.model.Cuentas;
import com.tapitapp.tapitapp.model.LineaCuenta;
import com.tapitapp.tapitapp.repository.ComandaRepository;
import com.tapitapp.tapitapp.util.AdapterComanda;
import com.tapitapp.tapitapp.util.AdapterCuenta;
import com.tapitapp.tapitapp.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CuentaActivity extends AppCompatActivity {
    private ComandaRepository repository = new ComandaRepository();
    List<LineaCuenta> ListLineaCuentas;
    RecyclerView recycler;
    TextView txtTotalCuenta;
    Button pedir,volver;
    conexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        conn=new conexionSQLiteHelper(getApplicationContext(),"Tapitapp.db",null,utilidades.VERSION);

        recycler =(RecyclerView) findViewById(R.id.ListCuenta);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        txtTotalCuenta=(TextView) findViewById(R.id.txt_cuenta);
        volver=(Button)findViewById(R.id.btnVolver);
        pedir=(Button)findViewById(R.id.btnPedir);

        SharedPreferences preferences=getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);

        ListLineaCuentas=repository.getLineasServidas(preferences.getInt("id",-1));

        //consultarCuenta();
        Double total = ListLineaCuentas.stream().mapToDouble(x->x.getTotal()).sum();
        txtTotalCuenta.setText("Total: " + Util.NumberFormat(total) + "€");

        AdapterCuenta adapter= new AdapterCuenta(ListLineaCuentas);


        recycler.setAdapter(adapter);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(intent);
            }
        });

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
            LineaCuenta.setTotal(cursor.getDouble(3));

            ListLineaCuentas.add(LineaCuenta);
        }
    }
}