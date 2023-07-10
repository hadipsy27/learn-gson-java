package com.labs.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.labs.app.entity.User;

import java.util.ArrayList;
import java.util.List;


public class GsonApp
{
    public static void main( String[] args ) {

        User user = new User();
        user.name = "Kokio";
        user.email = "kokio@gmail.com";
        user.umur = 23;

        List<String> users1 = new ArrayList<>();
        users1.add("jono");
        users1.add("jono@mail.com");
        users1.add(String.valueOf(24));

        for (String val : users1){
            System.out.println(val);
        }

        // Mengubah Object menjadi String JSON
        Gson gson = new Gson();
        String jsonUser = gson.toJson(user);
        System.out.println();
        System.out.println("--- Object To JSON ---");
        System.out.println(jsonUser);

        // Mengubah String JSON menjadi object
        Gson gsonBuilder = new GsonBuilder().create();
        User userFromJson = gsonBuilder.fromJson(jsonUser, User.class);
        System.out.println();
        System.out.println("--- JSON To Object ---");
        System.out.println(userFromJson.name);
        System.out.println(userFromJson.email);
        System.out.println(userFromJson.umur);

        String userJson = gson.toJson(userFromJson);
        System.out.println();
        System.out.println(userJson);

        User users = new User();
        users.name = userFromJson.name;
        users.email = userFromJson.email;
        users.umur = userFromJson.umur;

        System.out.println();
        System.out.println(users.getName());
        System.out.println(users.getEmail());
        System.out.println(users.getUmur());
        System.out.println();

        List<String> listUser = new ArrayList<>();
        listUser.add(users.getName());
        listUser.add(users.getEmail());
        listUser.add(String.valueOf(users.getUmur()));

        for(String value : listUser){
            System.out.println(value);
        }

        User userFromList = new User();
        userFromList.setName(listUser.get(0));
        userFromList.setEmail(listUser.get(1));
        System.out.println();
        System.out.println(userFromList.getName());
        System.out.println(userFromList.getEmail());


    }
}
