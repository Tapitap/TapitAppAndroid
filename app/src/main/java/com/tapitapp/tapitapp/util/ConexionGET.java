package com.tapitapp.tapitapp.util;

import android.content.Context;
import android.os.AsyncTask;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.Toast;

import com.tapitapp.tapitapp.model.Mesas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;

public class ConexionGET extends AsyncTask<String, String, String>{

    public void getMesaByUsername(String username) {

    }

    @Override
    public String doInBackground(String... params) {
        //String url1 = "http://tapitapp.orgfree.com/servicioPHP/registrar.php?username=" + params[0];
        //Mesas resultado = null;
        try{
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.connect();
            int code = connection.getResponseCode();
            if(code == HttpURLConnection.HTTP_OK){
                InputStream inputStream = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                StringBuffer buffer = new StringBuffer();
                while((line = reader.readLine()) != null){
                    buffer.append(line);
                }
                inputStream.close();
                connection.disconnect();
                return buffer.toString();
            }
            //connection.setRequestMethod("GET");
            //connection.setDoOutput(true);
            //OutputStream outputStream = connection.getOutputStream();
            // bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));



            // data = URLEncoder.encode("username","UTF-8") + "=" + URLEncoder.encode(username,"UTF-8");
            //bufferedWriter.write(data);
            //bufferedWriter.flush();
            //bufferedWriter.close();
            //outputStream.close();

            //InputStream inputStream = new BufferedInputStream(connection.getInputStream());


        }catch (MalformedInputException ex){
            Log.d("TapitApp", "Se ha utilizado una URL con formato incorrecto");
            //resultado = "Se ha producido un error";
        }catch (IOException EX){
            Log.d("TapitaApp", "Error inesperado!, posibles problemas de conexion de red");
            //resultado = "Se ha producido un Error, comprueba tu conexion a internet";
        }
        return null;
    }

    protected void onPostExecute(String resultado){
        //Toast.makeText(context.get(),resultado,Toast.LENGTH_LONG).show();
    }

    public Mesas ParseToMesa(InputStream input){
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input,StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }

            JSONObject JSON = new JSONObject(stringBuilder.toString());
            String username = JSON.getJSONObject("MesaUser").getString("username");
            String password = JSON.getJSONObject("MesaUser").getString("password");
            String enable = JSON.getJSONObject("MesaUser").getString("enable");
            String nuemero = JSON.getJSONObject("MesaUser").getString("numero");
            String id_manager = JSON.getJSONObject("MesaUser").getString("enable");
            String authority = JSON.getJSONObject("MesaUser").getString("authority");
            bufferedReader.close();
        }catch (JSONException EX){
            Log.d("TapitaApp", EX.getMessage());
        }catch (IOException EX){
            Log.d("TapitaApp", "Error inesperado!, posibles problemas de conexion de red");
            //resultado = "Se ha producido un Error, comprueba tu conexion a internet";
        }
        return null;
    }

}
