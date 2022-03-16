package com.tapitapp.tapitapp.repository;

import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.util.ConexionGET;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductosRepository {

    public  List<Productos> GetProductoByTipo(Integer idManager, String tipo){
        List<Productos>productos = new ArrayList<Productos>();

        ConexionGET conexionGET = new ConexionGET();
        try{
            String result = conexionGET.execute("http://tapitapp.orgfree.com/servicioPHP/Productos/getByTipo.php?id_manager=" + idManager.toString() + "&tipo="+tipo).get();
            JSONObject json = new JSONObject(result);

            String estado = json.getString("estado");

            switch (estado) {
                case "1":
                    JSONArray array = json.getJSONArray("Productos");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        Productos producto = parseJSONToProducto(object);
                        productos.add(producto);
                    }
                    break;
                case "-1":
                    throw new Exception(json.getString("mensaje"));
            }



        }catch (Exception e){
            e.printStackTrace();
        }
        return productos;
    }

    private Productos parseJSONToProducto(JSONObject json) throws JSONException {

        String nombre = json.isNull("nombre")?null:json.getString("nombre");
        String descripcion = json.isNull("descripcion")?null:json.getString("descripcion");
        Double precio = json.isNull("precio")?null:json.getDouble("precio");
        Integer id_manager = json.isNull("id_manager")?null:json.getInt("id_manager");
        Integer id_producto = json.isNull("id")?null:json.getInt("id");
        String tipo = json.isNull("tipo")?null:json.getString("tipo");
        String tipoPlato = json.isNull("tipoplato")?null:json.getString("tipoplato");
        return new Productos(id_manager,id_producto,nombre,descripcion,tipo,tipoPlato,precio);
    }
}
