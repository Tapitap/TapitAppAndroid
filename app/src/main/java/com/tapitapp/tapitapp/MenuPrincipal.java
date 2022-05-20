package com.tapitapp.tapitapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {

    Button comanda;
    Button cartacomida;
    Button cartaBebida;
    Button cartaPostre;
    Button cartaCombinados;
    Button btnCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        comanda=findViewById(R.id.btnCcomanda);
        cartacomida=(Button)findViewById(R.id.btnCarta);
        cartaBebida=(Button)findViewById(R.id.btnBebidas);
        cartaPostre=(Button)findViewById(R.id.btnPostres);
        cartaCombinados=(Button)findViewById(R.id.btnCombinados);
        btnCuenta=(Button)findViewById(R.id.btnCuenta);


        comanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ComandaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CuentaActivity.class);
                startActivity(intent);
            }
        });
        cartaCombinados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), BotonEleccion.class);
                intent.putExtra("tipo","combinado");
                startActivity(intent);
            }
        });
        cartaPostre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), BotonEleccion.class);
                intent.putExtra("tipo","postre");
                startActivity(intent);
            }
        });
        cartaBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), BotonEleccion.class);
                intent.putExtra("tipo","bebida");
                startActivity(intent);
            }
        });

        cartacomida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), BotonEleccion.class);
                intent.putExtra("tipo","comida");
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder=new AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog_Alert);
            builder.setMessage("¿Desea salir de TapiTapp?")
                    .setPositiveButton("si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent inten= new Intent(Intent.ACTION_MAIN);
                            inten.addCategory(Intent.CATEGORY_HOME);
                            inten.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(inten);
                        }
                    }).setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();

        }
        return  super.onKeyDown(keyCode,event);
    }

}