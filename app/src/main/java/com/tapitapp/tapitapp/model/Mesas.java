package com.tapitapp.tapitapp.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Mesas{

    private String username;
    private boolean enable;
    private String authority;
    private Integer id;
    private Integer numero;
    private Integer id_manager;

    public Mesas(String username, boolean enable, String authority, Integer id, Integer num, Integer id_manager) {
        this.username = username;
        this.enable = enable;
        this.authority = authority;
        this.id = id;
        this.numero = num;
        this.id_manager = id_manager;
    }

    public Mesas(JSONObject json) throws JSONException {
        this.username = json.has("username")?(json.isNull("username")?null:json.getString("username")):null;
        this.enable = json.has("enable")?(json.isNull("enable")?enable:!Boolean.parseBoolean(json.getString("enable"))):enable;
        this.id = json.has("id")?(json.isNull("id")?id:json.getInt("id")):id;
        this.numero = json.has("numero")?(json.isNull("numero")?numero:json.getInt("numero")):numero;
        this.id_manager = json.has("id_manager")?(json.isNull("id_manager")?id_manager:json.getInt("id_manager")):id_manager;
        this.authority = json.has("authority")?(json.isNull("authority")?null:json.getString("authority")):null;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public boolean getEnable(){
        return this.enable;
    }

    public void setEnable(boolean enable){
        this.enable = enable;
    }

    public String getAuthority() {return this.authority;}

    public void setAuthority(String authority){this.authority = authority;}

    public Integer getId(){return this.id;}

    public void setId(Integer id){this.id = id;}

    public Integer getNum(){
        return this.numero;
    }

    public void setNum(Integer num) {
        this.numero = num;
    }

    public Integer getId_manager(){
        return this.id_manager;
    }

    public void setId_manager(Integer id_manager) {
        this.id_manager = id_manager;
    }
}