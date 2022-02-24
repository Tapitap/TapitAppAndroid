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

    Button cerrar;
    Button cartacomida;
    Button cartaBebida;
    Button cartaPostre;
    Button cartaCombinados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        cerrar=findViewById(R.id.btnCerrar);
        cartacomida=(Button)findViewById(R.id.btnCarta);
        cartaBebida=(Button)findViewById(R.id.btnBebidas);
        cartaPostre=(Button)findViewById(R.id.btnPostres);
        cartaCombinados=(Button)findViewById(R.id.btnCombinados);


        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences=getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
                preferences.edit().clear().commit();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
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
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
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