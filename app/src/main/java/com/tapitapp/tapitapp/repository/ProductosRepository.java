package com.tapitapp.tapitapp.repository;

import android.media.Image;

import com.tapitapp.tapitapp.model.Precios;
import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.util.ConexionGET;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductosRepository {

    private String URL = "http://tapitapp.orgfree.com/servicioPHP/Productos/";

    //---------METODOS PUBLICOS---------//

    public  List<Productos> GetProductoByTipo(Integer idManager, String tipo){
        List<Productos>productos = new ArrayList<Productos>();

        ConexionGET conexionGET = new ConexionGET();
        try{
            String result = conexionGET.execute(URL + "getByTipo.php?id_manager=" + idManager.toString() + "&tipo="+tipo).get();
            JSONObject json = new JSONObject(result);

            String estado = json.getString("estado");

            switch (estado) {
                case "1":
                    JSONArray array = json.getJSONArray("Productos");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        Productos producto = parseJSONToProducto(object);
                        producto.setPrecios(getPreciosByIdProducto(producto.getId()));
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

    public Productos getProductoById(Integer id){
        Productos res = null;

        ConexionGET conexionGET = new ConexionGET();
        try {
            String result = conexionGET.execute(URL + "getById.php?id=" + id).get();
            JSONObject json = new JSONObject(result);

            String estado = json.getString("estado");

            switch (estado) {
                case "1":
                    res = parseJSONToProducto(json.getJSONObject("Poducto"));
                    res.setPrecios(getPreciosByIdProducto(res.getId()));
                case "-1":
                    throw new Exception(json.getString("mensaje"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    //---------METODOS AUXILIARES---------//

    private List<Precios> getPreciosByIdProducto(Integer id){
        List<Precios> res = new ArrayList<>();
        ConexionGET conexionGET = new ConexionGET();
        try {
            String result = conexionGET.execute(URL + "getPreciosById.php?id_producto=" + id).get();
            JSONObject json = new JSONObject(result);
            String estado = json.getString("estado");
            switch (estado){
                case "1":
                    JSONArray array = json.getJSONArray("Precios");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        Precios precios = parseJSONToPrecio(object) ;
                        res.add(precios);
                    }
                    break;
                case "-1":
                    throw new Exception(json.getString("mensaje"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    private Image getIcoById(Integer id){
        Image res = null;
        ConexionGET conexionGET = new ConexionGET();
        try {
            String result = conexionGET.execute(URL + "getIcoById.php?id=" + id).get();

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    private Image getImgById(Integer id){
        Image res = null;
        ConexionGET conexionGET = new ConexionGET();
        try {
            String result = conexionGET.execute(URL + "getImgById.php?id=" + id).get();

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    private Productos parseJSONToProducto(JSONObject json) throws JSONException {

        Integer id = json.isNull("id")?null:json.getInt("id");
        String nombre = json.isNull("nombre")?null:json.getString("nombre");
        String descripcion = json.isNull("descripcion")?null:json.getString("descripcion");
        Integer id_manager = json.isNull("id_manager")?null:json.getInt("id_manager");
        String tipo = json.isNull("tipo")?null:json.getString("tipo");
        boolean oferta = json.isNull("oferta")?false:json.getString("oferta").equals("0")?false:true;
        return new Productos(id,id_manager,nombre,descripcion,tipo,null,oferta);
    }

    private Precios parseJSONToPrecio(JSONObject json) throws JSONException{
        Integer id = json.isNull("id")?null:json.getInt("id");
        String tipo = json.isNull("tipo")?null:json.getString("tipo");
        Double cuantia = json.isNull("cuantia")?0.:json.getDouble("cuantia");
        return new Precios(id,tipo,cuantia);
    }
}
