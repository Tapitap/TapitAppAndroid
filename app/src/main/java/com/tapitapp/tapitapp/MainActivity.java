package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tapitapp.tapitapp.model.Mesas;
import com.tapitapp.tapitapp.repository.MesasRepository;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView txtUser,txtPass;
    Button btnLog;
    String user,pass;
    private MesasRepository repository = new MesasRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser=(TextView) findViewById(R.id.edtUsuario);
        txtPass=(TextView) findViewById(R.id.edtPassword);
        btnLog= (Button) findViewById(R.id.btnLogin);

        RecuperarPreferencias();

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=txtUser.getText().toString();
                pass=txtPass.getText().toString();
                try{
                    boolean res = repository.getLogin(user,pass);
                    if(res) {
                        Mesas mesa = repository.GetByUsername(user);
                        Intent intent = new Intent(getApplicationContext(),MenuPrincipal.class);
                        guardarPreferencias();
                        startActivity(intent);
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    //este metodo es para manener la sesion abierta
    private void guardarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("usuario",user);
        editor.putString("password",pass);
        editor.putBoolean("sesion", true);
        editor.commit();
    }
    private void RecuperarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        txtUser.setText(preferences.getString("usuario",user));
        txtPass.setText(preferences.getString("password",pass));

    }

}