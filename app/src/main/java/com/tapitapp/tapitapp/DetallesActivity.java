package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallesActivity extends AppCompatActivity {

    Button btnMas,btnMenos;
    TextView txtCantidad;
    Integer valor=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        btnMas=(Button) findViewById(R.id.btnMas);
        btnMenos=(Button)findViewById(R.id.btnMenos);
        txtCantidad=(TextView) findViewById(R.id.txtCantidad);


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