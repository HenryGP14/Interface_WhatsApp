package com.example.interfas_whatsapp.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class user {
    private String email, first_name, last_name, avatar;

    public user(String email, String first_name, String last_name, String avatar) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public user(JSONObject a) throws JSONException {
        first_name =  a.getString("first_name").toString() + " " + a.getString("last_name").toString();

        email =  a.getString("email").toString() ;
        avatar =  a.getString("avatar").toString() ;
        avatar = a.getString("avatar").toString() ;


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
}
