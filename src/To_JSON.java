// package com.howtodoinjava.demo.jsonsimple;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.URL;

public class To_JSON {
    public static void main(String[] args){

        System.out.println("updated!");

        JSONObject champions = new JSONObject();

        champions.put("Most played", "Ornn");
        champions.put("2nd most played", "Camille");
        champions.put("3rd most played", "Shen");

        JSONObject role = new JSONObject();

        role.put("Primary role", "Top");
        role.put("Secondary role", "Mid");

        JSONObject rankedStats = new JSONObject();

        rankedStats.put("Champion Statistics", champions);
        rankedStats.put("Roles", role);

        JSONArray rankedStatsArray = new JSONArray();

        rankedStatsArray.add(champions);
        rankedStatsArray.add(role);

        String url = "http://www.google.com";

        try{
            URL riotURL = new URL(url);
        }
        catch(java.net.MalformedURLException error){
            System.out.println("Error with " + url);
        }


        //Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) {

            file.write(rankedStats.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
