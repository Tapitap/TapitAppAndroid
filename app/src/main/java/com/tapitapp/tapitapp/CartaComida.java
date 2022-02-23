package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.repository.ProductosRepository;

import java.util.ArrayList;
import java.util.List;

public class CartaComida extends AppCompatActivity {

    private ProductosRepository repository = new ProductosRepository();
    TextView txt,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_comida);

        txt=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        List<Productos> producto = repository.GetProductoByTipo(1,"comida");



    }
}