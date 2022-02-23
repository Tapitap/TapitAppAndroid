package com.tapitapp.tapitapp.repository;

import com.tapitapp.tapitapp.model.Mesas;
import com.tapitapp.tapitapp.util.ConexionGET;
import com.tapitapp.tapitapp.util.ConexionPOST;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MesasRepository {

    public boolean getLogin(String username,String password) throws Exception {
        boolean res = false;
        ConexionPOST conexionPOST = new ConexionPOST();
        try{
            String[] params = {"http://tapitapp.orgfree.com/servicioPHP/MesaUser/login.php","username",username,"password",password};
            String result = conexionPOST.execute(params).get();
            JSONObject json = new JSONObject(result);

            String estado = json.getString("estado");

            switch (estado) {
                case "1":
                    return true;
                case "-1":
                    throw new Exception(json.getString("mensaje"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return res;
    }

    public Mesas GetByUsername(String username){
        Mesas mesa = null;

        ConexionGET conexionGET = new ConexionGET();
        try{
            String result = conexionGET.execute("http://tapitapp.orgfree.com/servicioPHP/MesaUser/getByUsername.php?username=" + username).get();
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
        boolean enable = Boolean.parseBoolean(json.getString("enable"));
        Integer numero = Integer.parseInt(json.getString("numero"));
        Integer id_manager = Integer.parseInt(json.getString("enable"));
        String authority = json.getString("authority");

        return new Mesas(user,null,authority,numero,id_manager);
    }
}