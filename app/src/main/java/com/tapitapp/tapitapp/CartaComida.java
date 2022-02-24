package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.repository.ProductosRepository;
import com.tapitapp.tapitapp.util.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class CartaComida extends AppCompatActivity {

    private ProductosRepository repository = new ProductosRepository();
    List<Productos> producto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_comida);




        init();


    }
    public void init(){
        producto = repository.GetProductoByTipo(1,"comida");
        ListAdapter ListAdapter = new ListAdapter(producto,this);
        RecyclerView recyclerView=findViewById(R.id.listProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        recyclerView.setAdapter(ListAdapter);


    }
}