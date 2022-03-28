package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.repository.ProductosRepository;

public class DetallesActivity extends AppCompatActivity {

    Button btnMas,btnMenos;
    ImageView img;
    TextView txtCantidad,txtName;
    Integer valor=1,id=0;
    Productos producto;
    private ProductosRepository repository = new ProductosRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        btnMas=(Button) findViewById(R.id.btnMas);
        btnMenos=(Button)findViewById(R.id.btnMenos);
        txtCantidad=(TextView) findViewById(R.id.txtCantidad);
        txtName=(TextView)findViewById(R.id.txtName);
        img=(ImageView)findViewById(R.id.imageViewDescricipcion);

        //traer productos
        id=getIntent().getIntExtra("id",0);

        producto=repository.getProductoById(id);
        img.setImageBitmap(repository.getImgById(id));

        txtName.setText(producto.getNombre().toString());

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor++;
                txtCantidad.setText(Integer.toString(valor));
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valor!=0){
                    valor--;
                    txtCantidad.setText(Integer.toString(valor));
                }
            }
        });
    }
}