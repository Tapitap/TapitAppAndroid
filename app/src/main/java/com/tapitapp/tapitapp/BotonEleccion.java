package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.repository.ProductosRepository;
import com.tapitapp.tapitapp.util.ListAdapter;

import java.util.List;

public class BotonEleccion extends AppCompatActivity {

    private ProductosRepository repository = new ProductosRepository();
    List<Productos> producto;
    String tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton_eleccion);



        init();


    }
    public void init(){
        tipo=getIntent().getStringExtra("tipo");

        producto = repository.GetProductoByTipo(1,tipo);
        ListAdapter ListAdapter = new ListAdapter(producto,this);
        RecyclerView recyclerView=findViewById(R.id.listProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        recyclerView.setAdapter(ListAdapter);


    }
}