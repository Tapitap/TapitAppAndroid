package com.tapitapp.tapitapp.model;

public class Mesas{

    private String username;
    private boolean enable;
    private String authority;
    private Integer id;
    private Integer num;
    private Integer id_manager;

    public Mesas(String username, boolean enable, String authority, Integer id, Integer num, Integer id_manager) {
        this.username = username;
        this.enable = enable;
        this.authority = authority;
        this.id = id;
        this.num = num;
        this.id_manager = id_manager;
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
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getId_manager(){
        return this.id_manager;
    }

    public void setId_manager(Integer id_manager) {
        this.id_manager = id_manager;
    }
}