package com.tapitapp.tapitapp.model;

public class Mesas extends Users{

    private Integer num;
    private Integer id_manager;

    public Mesas(String username, String password, String authority, Integer num, Integer id_manager) {
        super(username, password, authority);
        this.num = num;
        this.id_manager = id_manager;
    }

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