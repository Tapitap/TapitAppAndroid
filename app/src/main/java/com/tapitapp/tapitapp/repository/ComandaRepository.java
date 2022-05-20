package com.tapitapp.tapitapp.repository;

import com.tapitapp.tapitapp.util.ConexionPOST;

import org.json.JSONObject;

public class ComandaRepository {

    private String Url = "http://servicio.tapitapp.es/servicioPHP/Comandas/";

    public int InsertComanda(int id_mesa) throws Exception{
        ConexionPOST conexionPOST = new ConexionPOST();
        String[] params = {Url + "insertComanda.php","id_mesa",String.valueOf(id_mesa)};
        String result = conexionPOST.execute(params).get();
        JSONObject json = new JSONObject(result);

        String estado = json.getString("estado");

        if(estado.equals("1")){
            return json.getInt("id");
        }else{
            throw new Exception(json.getString("mensaje"));
        }
    }

    public void InsertLinea(int id_comanda,int id_producto, double precio, int cantidad) throws Exception{
        ConexionPOST conexionPOST = new ConexionPOST();
        String[] params = {
                Url + "insertLinea.php",
                "id_comanda",String.valueOf(id_comanda),
                "id_producto",String.valueOf(id_producto),
                "cuantia",String.valueOf(precio),
                "cantidad",String.valueOf(cantidad)
        };
        String result = conexionPOST.execute(params).get();
        JSONObject json = new JSONObject(result);

        String estado = json.getString("estado");

        if(estado.equals("-1")){
            throw new Exception(json.getString("mensaje"));
        }
    }
}
