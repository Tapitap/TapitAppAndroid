package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.repository.ProductosRepository;
import com.tapitapp.tapitapp.util.ListAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BotonEleccion extends AppCompatActivity {

    private ProductosRepository repository = new ProductosRepository();
    List<Productos> productos;
    String tipo;
    Integer id_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton_eleccion);

        init();

    }
    public void init(){

        SharedPreferences preferences=getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);

        tipo=getIntent().getStringExtra("tipo");
        id_manager=preferences.getInt("id_manager",1);
        productos = repository.GetProductoByTipo(id_manager,tipo);

        ListAdapter ListAdapter = new ListAdapter(productos,this);
        RecyclerView recyclerView=findViewById(R.id.listProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        recyclerView.setAdapter(ListAdapter);
    }
}