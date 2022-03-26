package com.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonManager {
    public static Object getFieldOrNAj(String field, JsonObject json) {
        JsonElement value = json.get(field);
        if (value != null) {
            // If the field was found, return its value
            return value.getAsJsonObject();
        } else {
            // Otherwise, return "N/A"
            return "N/A";
        }
    }

    public static JsonArray getFieldOrNAa(String field, JsonObject json) {
        JsonElement value = json.get(field);
        if (value != null) {
            // If the field was found, return its value
            return value.getAsJsonArray();
        } else {
            // Otherwise, return "N/A"
            return null;
        }
    }

    public static String getFieldOrNA(String field, JsonObject json) {
        JsonElement value = json.get(field);
        if (value != null) {
            // If the field was found, return its value
            return value.getAsString();
        } else {
            // Otherwise, return "N/A"
            return "N/A";
        }
    }

    public static int getItemlength(int Number) {
        int lenght = (JsonManager.getFieldOrNA("Value" + Number,
                folder.readGame("/Counter Files\\settings.txt"))).length();
        return lenght;
    }

    public static JsonElement getObjectNumX(int num, JsonArray array) {
        JsonElement value = array.get(num);
        if (value != null) {
            // If the field was found, return its value

            return value;
        } else {
            // Otherwise, return "N/A"
            return null;
        }
    }

    // public static String JsonObjectToString(@NotNull JsonObject jsonObject){
    // return jsonObject.toString();
    // }

    public static JsonObject StringToJsonObject(String string) {
        return JsonParser.parseString(string).getAsJsonObject();
    }

    // public static JsonObject JsonArrayToJsonObject(JsonArray jsonArray){
    // return jsonArray.getAsJsonObject();
    // }

}
