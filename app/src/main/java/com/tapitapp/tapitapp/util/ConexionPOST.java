package com.tapitapp.tapitapp.util;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;

public class ConexionPOST extends AsyncTask<String, String, String> {

    @Override
    public String doInBackground(String... params) {
        try{
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String data = ParametrosURL(params);
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

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

    private String ParametrosURL(String... params) throws UnsupportedEncodingException {
        String data = "";
        for(int i = 1; i < params.length-1; i++){
            data += URLEncoder.encode(params[i],"UTF-8");

            if(i%2 == 0){data += "&";}else{data += "=";}
        }
        data += URLEncoder.encode(params[params.length-1],"UTF-8");
        return data;
    }
}
