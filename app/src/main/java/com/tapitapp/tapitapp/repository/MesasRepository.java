package com.tapitapp.tapitapp.repository;

import com.tapitapp.tapitapp.model.Mesas;
import com.tapitapp.tapitapp.util.ConexionGET;
import com.tapitapp.tapitapp.util.ConexionPOST;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MesasRepository {
    private String Url = "http://servicio.tapitapp.es/servicioPHP/Users/";

    public String getLogin(String username, String password) throws Exception {
        ConexionPOST conexionPOST = new ConexionPOST();
        String[] params = {Url + "login.php","username",username,"password",password};
        String result = conexionPOST.execute(params).get();
        JSONObject json = new JSONObject(result);

        String estado = json.getString("estado");

        if(estado.equals("1")){
            return json.getString("authority");
        }else{
            throw new Exception(json.getString("mensaje"));
        }
    }

    public Mesas GetByUsername(String username){
        Mesas mesa = null;
        ConexionGET conexionGET = new ConexionGET();
        try{
            String result = conexionGET.execute(Url + "getMesaByUsername.php?username=" + username).get();
            JSONObject json = new JSONObject(result);

            String estado = json.getString("estado");

            switch (estado) {
                case "1":
                    return parseJSONToMesa(json.getJSONObject("MesaUser"));
                case "-1":
                    throw new Exception(json.getString("mensaje"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mesa;
    }

    private Mesas parseJSONToMesa(JSONObject json) throws JSONException {

        String user = json.getString("username");
        boolean enable = !Boolean.parseBoolean(json.getString("enable"));
        Integer numero = Integer.parseInt(json.getString("numero"));
        Integer id_manager = Integer.parseInt(json.getString("enable"));
        String authority = json.getString("authority");

        return new Mesas(user,enable,authority,numero,id_manager);
    }
}