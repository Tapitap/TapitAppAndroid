package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.tapitapp.tapitapp.db.conexionSQLiteHelper;
import com.tapitapp.tapitapp.db.utilidades;
import com.tapitapp.tapitapp.model.Comandas;
import com.tapitapp.tapitapp.util.AdapterComanda;

import java.util.ArrayList;

public class ComandaActivity extends AppCompatActivity {

    ArrayList<Comandas>ListComandas;
    RecyclerView recycler;

    conexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda);

        conn=new conexionSQLiteHelper(getApplicationContext(),"Tapitapp.db",null,1);
        recycler =(RecyclerView) findViewById(R.id.ListComanda);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        ListComandas=new ArrayList<>();

        consultar();

        AdapterComanda adapter = new AdapterComanda(ListComandas);


        recycler.setAdapter(adapter);


    }

    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Comandas comanda = null;

        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_LINEA, null);

        while (cursor.moveToNext()){
            comanda=new Comandas();
            comanda.setId_comanda(cursor.getInt(0));
            comanda.setId_producto(cursor.getInt(1));
            comanda.setNombre(cursor.getString(2));
            comanda.setId_precio(cursor.getDouble(3));
            comanda.setCantidad(cursor.getInt(4));
            comanda.setTotal(cursor.getDouble(5));

            ListComandas.add(comanda);
        }
    }


}