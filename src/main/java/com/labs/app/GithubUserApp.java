package com.labs.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.labs.app.entity.GithubUser;
import com.labs.app.entity.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GithubUserApp {
    public static void main(String[] args) {

        User myUser = new User();
        myUser.setName("Hadi");
        myUser.setEmail("hadipsy27@gmail.com");
        myUser.setUmur(25);

        // ubah objek menjadi string JSON
        Gson gson = new Gson();
        String jsonUser = gson.toJson(myUser);
        System.out.println(jsonUser);

        // ubah String JSON menjadi object
        Gson gsonBuilder = new GsonBuilder().create();
        User userObj = gsonBuilder.fromJson(jsonUser, User.class);
        System.out.println(userObj.name);
        System.out.println(userObj.getEmail());
        System.out.println("--------------------------------------");

        // Deserialize data JSON dari webservice
        try {
            String jsonWeb = getJson("https://api.github.com/users/hadipsy27");
            GithubUser githubUser = gson.fromJson(jsonWeb, GithubUser.class);
            System.out.println("Hasil --------------------------------");
            System.out.println(githubUser.getName());
            System.out.println(githubUser.getAvatar_url());
            System.out.println(githubUser.getHtml_url());
            System.out.println(githubUser.getBio());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getJson(String url) throws Exception{

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("Accept", "application/json");
        request.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X)");

        HttpResponse response = client.execute(request);

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}
