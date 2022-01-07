package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.*;
import java.util.ArrayList;

public class FileWriteAndRead {

    public static void fileWriter(ArrayList<FormulaDriver> driver) throws IOException {
        File file = new File("database.json");
        FileWriter writer = new FileWriter(file, false);
        BufferedWriter buffWriter = new BufferedWriter(writer);
        Gson gson = new Gson();
        String object = gson.toJson(driver);
        System.out.println(object);
        try {
            buffWriter.write(object);
            buffWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Object> fileReader() throws FileNotFoundException {
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<FormulaDriver> drivers = new ArrayList<>();
        ArrayList<CarCons> teams = new ArrayList<>();
        File file = new File("database.json");
        FileReader reader = new FileReader(file);
        Gson jsonData = new Gson();
        JsonArray data = jsonData.fromJson(reader, JsonArray.class);
        if(data!=null){
            for(JsonElement obj: data){
                String name = obj.getAsJsonObject().get("name").getAsString();
                int age = obj.getAsJsonObject().get("age").getAsInt();
                String cntry = obj.getAsJsonObject().get("country").getAsString();
                String gndr = obj.getAsJsonObject().get("gender").getAsString();
                String team = obj.getAsJsonObject().get("teamName").getAsString();
                int score = obj.getAsJsonObject().get("score").getAsInt();
                int numOfRaces = obj.getAsJsonObject().get("numOfRaces").getAsInt();
                JsonArray jPos = obj.getAsJsonObject().get("pos").getAsJsonArray();
                int[] pos = jsonArrToIntArr(jPos);
                int startPos = obj.getAsJsonObject().get("startPos").getAsInt();
                int winProb = obj.getAsJsonObject().get("winProb").getAsInt();
                int currentPos = obj.getAsJsonObject().get("currentPos").getAsInt();
                FormulaDriver driver = new FormulaDriver(name, age, cntry, gndr, team, score, numOfRaces, pos, startPos, winProb, currentPos);
                drivers.add(driver);
                teams.add(driver.getTeam());
            }
        }
        list.add(drivers);
        list.add(teams);
        return list;
    }

    public static int[] jsonArrToIntArr(JsonArray jArr){
        int[] intArr = new int[jArr.size()];
        for(int i = 0; i < intArr.length; i++){
            intArr[i] = jArr.get(i).getAsInt();
        }
        return intArr;
    }
}
