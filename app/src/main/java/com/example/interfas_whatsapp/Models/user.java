package com.example.interfas_whatsapp.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class user {
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private String mensage;

    public user(String email, String first_name, String last_name, String avatar, String mensage) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.mensage = mensage;
    }

    public user(JSONObject a) throws JSONException {
        first_name =  a.getString("first_name").toString() + " " + a.getString("last_name").toString();

        email =  a.getString("email");
        avatar =  a.getString("avatar");
        avatar = a.getString("avatar") ;

    }

    public static ArrayList<user> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<user> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            usuarios.add(new user(datos.getJSONObject(i)));
        }
        return usuarios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
}
