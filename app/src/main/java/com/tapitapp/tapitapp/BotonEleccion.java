package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.repository.ProductosRepository;
import com.tapitapp.tapitapp.util.ListAdapter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BotonEleccion extends AppCompatActivity {

    private ProductosRepository repository = new ProductosRepository();
    List<String> nombres;
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
        tipo=getIntent().getStringExtra("tipo");

        productos = repository.GetProductoByTipo(1,tipo);
        nombres = productos.stream().map(x->x.getNombre()).distinct().collect(Collectors.toList());
        ListAdapter ListAdapter = new ListAdapter(nombres, productos,this);
        RecyclerView recyclerView=findViewById(R.id.listProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        recyclerView.setAdapter(ListAdapter);
        ListAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DetallesActivity.class);
                startActivity(intent);
            }
        });


    }
}