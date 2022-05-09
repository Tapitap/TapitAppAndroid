package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Marchando extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marchando);
        int tiempoTranscurrir = 3000; //1 segundo, 1000 millisegundos.

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //***Aquí agregamos el proceso a ejecutar.

                Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity(intent);

                handler.removeCallbacks(null);
            }
        }, tiempoTranscurrir );//define el tiempo.
    }
}