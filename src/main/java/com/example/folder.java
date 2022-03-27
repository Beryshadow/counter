package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class folder {
    public static void createFile() {
        File f1 = new File("/Counter Files");
        File f2 = new File("/Counter Files\\Saves");
        JsonObject fileData = JsonParser.parseString("{}").getAsJsonObject();
        File myObj = new File("/Counter Files\\settings.txt");
        try {
            myObj.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (readGame("/Counter Files\\settings.txt") != null) {
            fileData = readGame("/Counter Files\\settings.txt");
        } else if (readGame("/Counter Files\\settings.txt") == null) {
            fileData = readGame("/Counter Files\\settings.txt");
            try {
                FileWriter myWriter = new FileWriter("/Counter Files\\settings.txt");
                myWriter.write(String.valueOf(
                        "{Color1:192FFF,Color2:FF2628,Color3:4AFF7C,Color4:FFD132,Buton1:e,Buton2:d,Buton3:c,Buton4:y,Buton5:g,Buton6:v,Cancel:Crtl+z,PauseT:spacebar,Escape:esc,Value1:1,Value2:2,Value3:-1,Value4:1,Value5:2,Value6:-1}"));
                myWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            if (String.valueOf(fileData).equals("{}")) {
                fileData.addProperty("contentAmount", "0");
                fileData.addProperty("team1Count", "0");
                fileData.addProperty("team2Count", "0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f1.mkdir();
        boolean bool = f2.mkdir();
        if (bool) {
            System.out.println("Storage folder created successfully");
        } else if (f1.exists()) {
            System.out.println("Files found");
        } else {
            System.out.println("Something went wrong with folder creation");
        }
    }

    public static void Log(int action) {
        // TODO instantiate this function
    }

    public static void NewGame(int number) { // use of api key = 0
        JsonObject fileData = JsonParser.parseString("{}").getAsJsonObject();
        File myObj = new File("/Counter Files\\Saves\\" + number + ".txt");
        try {
            myObj.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Read the file
        if (readGame("/Counter Files\\Saves\\" + number + ".txt") != null) {
            fileData = readGame("/Counter Files\\Saves\\" + number + ".txt");
        }
        // write to file
        try {
            FileWriter myWriter = new FileWriter("/Counter Files\\Saves\\" + number + ".txt");
            if (String.valueOf(fileData).equals("{}")) {
                fileData.addProperty("contentAmount", "0");
                fileData.addProperty("team1Count", "0");
                fileData.addProperty("team2Count", "0");
                // fileData.addProperty("1", String.valueOf(111111)); // Initialize with first
                // data section
            } else {
                int templength = 0;
                while (true) {
                    templength++;
                    if (JsonManager.getFieldOrNA(String.valueOf(templength), fileData).equals("N/A")) {
                        break;
                    }
                }
                // String temp1 = JsonManager.getFieldOrNA(String.valueOf(templength - 1),
                // fileData);
                // fileData.addProperty(String.valueOf(templength), 333333);
                // fileData.addProperty("contentAmount",
                // Integer.parseInt(JsonManager.getFieldOrNA("contentAmount", fileData)) + 1);
            }
            myWriter.write(String.valueOf(fileData));
            myWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static JsonObject readGame(String path) {
        JsonObject data = null;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String temp = myReader.nextLine();
                data = JsonParser.parseString(temp).getAsJsonObject();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("An error occurred while reading game number " + path);
            e.printStackTrace();
        }
        return data;
    }
}
