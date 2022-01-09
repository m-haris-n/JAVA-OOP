package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class DateWriteAndRead {
    public static void fileWriter(HashMap<LocalDate, String> driver) throws IOException {
        File file = new File("dateHistory.json");
        FileWriter writer = new FileWriter(file, false);
        BufferedWriter buffWriter = new BufferedWriter(writer);
        Gson gson = new Gson();
        String object = gson.toJson(driver);
        try {
            buffWriter.write(object);
            buffWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<LocalDate, String> fileReader() throws FileNotFoundException {
        HashMap<LocalDate, String> raceHistory = new HashMap<>();

        File file = new File("dateHistory.json");
        FileReader reader = new FileReader(file);
        Gson jsonData = new Gson();
        JsonObject data = jsonData.fromJson(reader, JsonObject.class);
        if (data!= null){
            Set<String> dates = data.keySet();
            System.out.println(dates);
            for (String dateStr: dates){
                String[] dateArr = dateStr.split("-");
                int year = Integer.parseInt(dateArr[0]);
                int month = Integer.parseInt(dateArr[1]);
                int day = Integer.parseInt(dateArr[2]);
                raceHistory.put(LocalDate.of(year, month, day), data.get(dateStr).getAsString());
            }
        }

        return raceHistory;
    }

    public static int[] jsonArrToIntArr(JsonArray jArr) {
        int[] intArr = new int[jArr.size()];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = jArr.get(i).getAsInt();
        }
        return intArr;
    }
}
