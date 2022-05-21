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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.tapitapp.tapitapp.db.conexionSQLiteHelper;
import com.tapitapp.tapitapp.db.utilidades;
import com.tapitapp.tapitapp.model.Comandas;
import com.tapitapp.tapitapp.model.LineaCuenta;
import com.tapitapp.tapitapp.repository.ComandaRepository;
import com.tapitapp.tapitapp.repository.ProductosRepository;
import com.tapitapp.tapitapp.util.AdapterComanda;

import java.util.ArrayList;

public class ComandaActivity extends AppCompatActivity {

    ArrayList<Comandas>ListComandas;
    RecyclerView recycler;
    Button enviar;
    ImageButton home;
    conexionSQLiteHelper conn;
    private ComandaRepository repository = new ComandaRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda);

        enviar=(Button)findViewById(R.id.btnEnviar);
        home=(ImageButton)findViewById(R.id.buttonHome);

        conn=new conexionSQLiteHelper(getApplicationContext(),"Tapitapp.db",null,utilidades.VERSION);

        recycler =(RecyclerView) findViewById(R.id.ListComanda);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        ListComandas=new ArrayList<>();

        consultar();

        AdapterComanda adapter = new AdapterComanda(ListComandas);


        recycler.setAdapter(adapter);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(intent);
            }
        });
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Enviado", Toast.LENGTH_SHORT).show();
                Insertarcomanda();
                EnviarComanda();
                SQLiteDatabase db = conn.getWritableDatabase();
                db.execSQL("DELETE FROM linea");
                Intent intent=new Intent(getApplicationContext(),Marchando.class);
                startActivity(intent);
            }
        });

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

    private void Insertarcomanda() {
        SQLiteDatabase db = conn.getWritableDatabase();

        for (Comandas comanda:ListComandas){
            ContentValues valores = new ContentValues();

            valores.put(utilidades.NombreCuenta,comanda.getNombre());
            valores.put(utilidades.CantidadCuenta,comanda.getCantidad());
            valores.put(utilidades.totalCuenta,comanda.getTotal());


            Long elemento=db.insert(utilidades.TABLA_LINEACUENTA,utilidades.IDLineaCuenta,valores);

        }
    }

    private void EnviarComanda(){
        SharedPreferences preferences=getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        try{
            int id_comanda = repository.InsertComanda(preferences.getInt("numero",1));
            for (Comandas comanda:ListComandas){
                repository.InsertLinea(id_comanda,comanda.getId_producto(),comanda.getId_precio(),comanda.getCantidad());
            }
        }catch (Exception e){
            Toast.makeText(ComandaActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
