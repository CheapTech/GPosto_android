package br.com.senacrs.gposto.LibClass;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int id;
    private String user;
    private String senha;
    private String email;

    /*public Usuario(int id, String user, String senha, String email) {
        this.id = id;
        this.user = user;
        this.senha = senha;
        this.email = email;
    }*/
    
    //get/set
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
