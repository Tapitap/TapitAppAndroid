package com.tapitapp.tapitapp.model;

public class Users {

    private String username;
    private String password;
    private String authority;

    public Users(String username,String password,String authority){
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getpassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getAuthority() {return this.authority;}
    public void setAuthority(String authority){this.authority = authority;}
}